package com.jiuyun.system.model;

import com.jiuyun.system.util.CommonDao2;
import com.jiuyun.system.view.BorrowingFeeFrame;
import com.jiuyun.system.vo.BorrowInfoVO;
import com.jiuyun.system.vo.BorrowingFeeVO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

/**
 * 借书费用的计算
 * 规则: 约定日期内还书 || 提前还书->费用为10元/本, 逾期后->每天额外收费1元/本;
 */
public class BorrowingFeeDao {
    /**
     * 返回应收金额
     * @return 应收金额Receivable
     */
    public static long getReceivable(String id) {
        long receivable = 0;
        //获取表中日期
        List<BorrowInfoVO> lists = getAllBooksReturn(id);
        Vector<Vector> allItems = new Vector<>();
        for (BorrowInfoVO bfvo : lists) {
            Vector<String> vector = new Vector<>();
            vector.add(bfvo.getShouldReturnDate());//应还日期
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String stime =sdf.format(date);//获取当前时间(实际还书日期)
            vector.add(stime);
            allItems.add(vector);
        }
        //获取每行的单个日期(表中一行等于一本书)
        Vector v;
        long pay=0;
        for(int i=0;i<allItems.size();i++){
            v=allItems.get(i);
            String due=v.get(0).toString();//应还日期
            String ret=v.get(1).toString();//归还日期
            //判断每本书是否逾期,然后计算借书费用
            if(toTimestamp(ret)==toTimestamp(due) || toTimestamp(ret)<toTimestamp(due)){
                pay=10;
            }else if(toTimestamp(ret)>toTimestamp(due)){
                long retMS=toTimestamp(ret);
                long dueMS=toTimestamp(due);
                //时间戳的差值除以一天的毫秒数为预期天数,也就是逾期后的费用
                long differMS=(retMS-dueMS)/24/60/60/1000;
                pay=10+differMS;
            }
            receivable=+pay;
        }
        return receivable;
    }

    /**
     * 将String型日期转化为时间戳(ms)
     * @param date 日期
     * @return 时间戳
     */
    public static long toTimestamp(String date){
        long timestamp = 0;
        try{
            DateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
            Date d=dft.parse(date);
            timestamp=d.getTime();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return timestamp;
    }

    /**
     * 返回找零金额
     * @return 找零
     */
    public static float getChange(BorrowingFeeFrame bff) {
        float change=0;
        long receivable=Long.parseLong(bff.receivableText.getText());
        float received=Float.parseFloat(bff.receivedText.getText());
        change=received-receivable;
        return change;
    }

    /**
     * 查询borrowinfo表全部数据
     */
    public static List<BorrowInfoVO> getAllBooksReturn(String id) {
        String sql = "select * from borrowinfo where borrowid="+id+" ";
        List<BorrowInfoVO> lists = CommonDao2.query(sql, BorrowInfoVO.class, null);
        return lists;
    }

    /**
     * 向收款记录表collection_record插入新的收费记录
     */
    public static boolean insertInfo(String str1,String str2,String str3,String str4,String str5){
        boolean isSuccess=false;
        String sql="insert into collection_record values (?,?,?,?,?)";
        isSuccess= CommonDao2.modify(sql, new String[]{str1, str2, str3, str4, str5});
        return isSuccess;
    }

    /**
     * 还书成功后更改状态
     */
    public static void changeState(BorrowingFeeFrame borrowingFeeFrame){
        int id =borrowingFeeFrame.backBook.centerTable.getSelectedRow();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String stime =sdf.format(date);//获取当前时间
        System.out.println(stime);
        String borrowId = (String)borrowingFeeFrame.backBook.listBorrow.get(id).getBorrowId();
        String sql1 = "update borrowinfo set borrowinfo.returnstate='已归还',borrowinfo.returntime='"+ stime+"' where borrowid='"+borrowId+"'";//更新借阅状态
        CommonDao.operModify(sql1, null);
        borrowingFeeFrame.backBook.getTable();
        borrowingFeeFrame.backBook.model.setDataVector(borrowingFeeFrame.backBook.field,borrowingFeeFrame.backBook.titles);
    }
}








