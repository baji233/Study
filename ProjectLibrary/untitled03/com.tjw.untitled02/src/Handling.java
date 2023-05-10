import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static com.sun.deploy.uitoolkit.ToolkitStore.dispose;

/**
 * 事件处理机制
 * 事件监听器
 */
public class Handling {
    public static void main(String[] args){

    }

    public void method01(){
        JButton jButton01=new JButton("登录");//事件源
        jButton01.setActionCommand("login");
        JButton jButton02=new JButton("退出");//事件源
        jButton02.setActionCommand("exit");
        ButtonLister buttonLister=new ButtonLister();//创建监听器
        jButton01.addActionListener(buttonLister);//注册
        jButton02.addActionListener(buttonLister);//注册
    }
}

/**
 * 为解决按钮中文名字容易出现乱码从而无法进行if语句判断,所以要用英文命名按钮
 */
class ButtonLister implements ActionListener {
    //条件被触发后,自动调用此事件处理程序
    @Override
    public void actionPerformed(ActionEvent e) {//动作事件 e
        //获取当前触发事件的按钮名字
        String btnValues=e.getActionCommand();//获取动作命令
        if("login".equals(btnValues)){
            //弹出一个标题为“消息”的信息消息对话框
            JOptionPane.showMessageDialog(null,"登录中...");
        }else if("exit".equals(btnValues)){
            //弹出一个对话框，其中包含Yes 、 No和Cancel选项；标题为Select an Option
            int i=JOptionPane.showConfirmDialog(null,"是否确定退出?");//返回一个int值表示用户的回应
            if(i==JOptionPane.YES_OPTION){
                try {
                    //销毁窗体
                    dispose();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        //实现事件处理
        System.out.println("按钮被点击");
    }
}
















