import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static com.sun.deploy.uitoolkit.ToolkitStore.dispose;

/**
 * �¼��������
 * �¼�������
 */
public class Handling {
    public static void main(String[] args){

    }

    public void method01(){
        JButton jButton01=new JButton("��¼");//�¼�Դ
        jButton01.setActionCommand("login");
        JButton jButton02=new JButton("�˳�");//�¼�Դ
        jButton02.setActionCommand("exit");
        ButtonLister buttonLister=new ButtonLister();//����������
        jButton01.addActionListener(buttonLister);//ע��
        jButton02.addActionListener(buttonLister);//ע��
    }
}

/**
 * Ϊ�����ť�����������׳�������Ӷ��޷�����if����ж�,����Ҫ��Ӣ��������ť
 */
class ButtonLister implements ActionListener {
    //������������,�Զ����ô��¼��������
    @Override
    public void actionPerformed(ActionEvent e) {//�����¼� e
        //��ȡ��ǰ�����¼��İ�ť����
        String btnValues=e.getActionCommand();//��ȡ��������
        if("login".equals(btnValues)){
            //����һ������Ϊ����Ϣ������Ϣ��Ϣ�Ի���
            JOptionPane.showMessageDialog(null,"��¼��...");
        }else if("exit".equals(btnValues)){
            //����һ���Ի������а���Yes �� No��Cancelѡ�����ΪSelect an Option
            int i=JOptionPane.showConfirmDialog(null,"�Ƿ�ȷ���˳�?");//����һ��intֵ��ʾ�û��Ļ�Ӧ
            if(i==JOptionPane.YES_OPTION){
                try {
                    //���ٴ���
                    dispose();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        //ʵ���¼�����
        System.out.println("��ť�����");
    }
}
















