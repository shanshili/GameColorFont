/**
  **����С��Ϸ**
 GameA:���֡�������ɫ
 GameB:���֡�������ɫ��������ɫ
 GameC:���֡�������ɫ��������ɫ��������״��ͼ�񻯽��棩
 */

//import game.option.GameOption;
//import javax.swing.text.AbstractDocument;
//import com.diogonunes.jcolor.Attribute;
import com.diogonunes.jcolor.Attribute;
import static com.diogonunes.jcolor.Attribute.*;
import static com.diogonunes.jcolor.Ansi.colorize;
import java.util.Objects;
import java.util.Scanner;

public class GameDemo2 {
    public static int KeyColor,KeyOption,answer=0,num = 0;
    public static Scanner Response, ContinueGame, GameDiff;
    public static String  ReGame, CloseColor, Diff;
    public static String[] ColorFont = new String[7];
    public static String[] option = new String[2];
//    public static String[] option2 = new String[3];
//    public static String[] color = new String[7];
    public static int[] colornum = {0,196,40,11,12,57,8};//�ں��̻����ϻ�
    Attribute txtColor = TEXT_COLOR(1);

    public static void main(String[] args) {
        ColorFont[0]="��ɫ";
        ColorFont[1]="��ɫ";
        ColorFont[2]="��ɫ";
        ColorFont[3]="��ɫ";
        ColorFont[4]="��ɫ";
        ColorFont[5]="��ɫ";
        ColorFont[6]="��ɫ";
        option[0]="����";
        option[1]="������ɫ";

//        option2[0]="������ɫ";
//        option2[1]="����";
//        option2[2]="����";
//        GameOption optionA = new GameOption("������ɫ");
//        GameOption optionB = new GameOption("����");

        while(true) {
            System.out.println("ѡ����Ϸ�Ѷȣ�\nA:��  \nB:����\n\n\033[0;3mINF:�鿴��Ϸ��Ϣ\033[0m\n\033[0;3m886:�˳���Ϸ\033[0m");
            GameDiff = new Scanner(System.in);
            Diff = GameDiff.nextLine();
            switch (Diff) {
                case "A":
                    GameA();
                    break;
                case "B":
                    System.out.println("GameB�����У������ڴ���");
                    break;
                case "INF":
                    System.out.println("**����С��Ϸ**\n" +
                            " GameA:���֡�������ɫ\n" +
                            " GameB:���֡�������ɫ��������ɫ(������)\n" +
                            " GameC:���֡�������ɫ��������ɫ��������״��ͼ�񻯽��棩(������)\n" +
                            " 22.3.20 build Demo1.0.0\n" +
                            " ���ߣ�LCR\n\n");
                    break;
                case "886":
                    System.exit(1);
                default: break;
            }
        }
    }

    public static void GameA() {
        int value = 0;
        do {
            num = 0;
            String[][] Content = new String[4][4];
            String[] Title;
            int cycle;
            Title = TitleGenerate();
            System.out.println(Title[0]);
            Content[0] = ContentGenera();
            Content[1] = ContentGenera();
            Content[2] = ContentGenera();
            Content[3][0] = "4";
            Content[3][2] = Title[1];
            Content[3][3] = Title[2];
            Content[3][1] = Title[3];
            for (cycle = 0; cycle < 3; cycle++) {
                System.out.println(Content[cycle][0] +"."+ colorize(Content[cycle][3], TEXT_COLOR(Integer.parseInt(Content[cycle][1]))));
            }
            System.out.println("4." + "������");
            Response = new Scanner(System.in);
            try
            {
                answer = Response.nextInt();
            }
            catch (Exception e) {
                System.out.println("���������Ӧ������һ������:");
                continue;
            }
            try
            {
                value = JudgeAnswer(Content[answer - 1], Title);  //ArrayIndexOutOfBoundsException�������ڴ˴�
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println("���������Ӧ������ѡ���ڵ�����:");
                continue;
            }
        } while (value != 1);
    }


/*
    public static void GameB(){
        for (j = 0; j < 3; j++) {
            for (i = 0; i < 7; i++) {
                System.out.println("��ѡ��" + ColorFont[i] + "��" + option2[j] + "��");
                System.out.println("A." + "\033[40;31;4m" + "��ɫ" + "\033[0m");//�׵׺�
                System.out.println("B." + "\033[41;32;4m" + "��ɫ" + "\033[0m");//�����
                System.out.println("C." + "\033[42;33;4m" + "��ɫ" + "\033[0m");//�̵׻�
                Response = new Scanner(System.in);
                answer = Response.nextLine();
                key = "A";
                if (Objects.equals(answer, key)) {
                    System.out.println("�ش���ȷ��");
                } else {
                    System.out.println("�ش����");
                }
                System.out.println("�Ƿ������Y/N");
                ContinueGame = new Scanner(System.in);
                ReGame = ContinueGame.nextLine();
                if (Objects.equals(ReGame, "Y")) {
                    System.out.println("next");
                } else {
                    return;
                }
            }
        }
    }
*/
    public static String[] ContentGenera(){
        int j2,i,j;
        i = (int)(Math.random()*2);
        j = (int)(Math.random()*7);
        j2 = (int)(Math.random()*7);
        String[] Content = new String[4];
        num++;
        Content[0] = String.valueOf(num);//���
        Content[1] = String.valueOf(colornum[j]);
        Content[2] = option[i];//option����
        Content[3] = ColorFont[j2];//��ɫ����

        return Content;
    }
    public static int JudgeAnswer(String[] Respond,String[] Answer){
        /*
        Respond:
        0:���
        1:��ɫ
        2:option����
        3:����
        Answer:
        0:��Ŀ
        1:option����
        2:��ɫ
         */
        if(Objects.equals(Answer[1],option[0])){//��Ŀ�ʵ���option[0]����
            if(Objects.equals(Respond[3], Answer[2]))//�ж�ѡ�������Ƿ�Ϊ��ĿҪ�������
            {
                System.out.println("�ش���ȷ��");
            }
            else System.out.println("�ش����");
        }
        if(Objects.equals(Answer[1], option[1])){//��Ŀ�ʵ���option[1]������ɫ
            if(Objects.equals(Respond[1], Answer[3]))
            {
                System.out.println("�ش���ȷ��");
            }
            else System.out.println("�ش����");
        }
        System.out.println("�Ƿ������Y/N");
        ContinueGame = new Scanner(System.in);
        ReGame = ContinueGame.nextLine();
        if (Objects.equals(ReGame, "N")) {
            return 1;
        }
        else {
            System.out.println("next");
            return 0;
        }
    }
    public static String[] TitleGenerate(){
        String[] Title = new String[4];
        KeyOption = (int)(Math.random()*2);
        KeyColor = (int)(Math.random()*7);
        Title[0] = "��ѡ��" + ColorFont[KeyColor] + "��" + option[KeyOption] + "��";
        Title[1] = option[KeyOption];
        Title[2] = ColorFont[KeyColor];
        Title[3] = String.valueOf(colornum[KeyColor]);
        return Title;
    }
/*
    public static void ColorTest(){
//        AnsiFormat fInfo = new AnsiFormat(CYAN_TEXT());
//        AnsiFormat fError = new AnsiFormat(YELLOW_TEXT(), RED_BACK());
//        System.out.println(fInfo.format("This info message will be cyan"));
//        System.out.println(fError.format("This error message will be yellow on red"));
//        System.out.println("\n");

//        for (int i = 0; i <= 255; i++) {
//            Attribute txtColor = TEXT_COLOR(i);
//            System.out.print(colorize(String.format("%4d", i), txtColor));
//        }
//        System.out.println("\n");
        int[] i={0,196,40,11,12,57,8};
        int j;
        for(j=0;j<7;j++) {
                Attribute txtColor = TEXT_COLOR(i[j]);
                System.out.print(colorize(String.format("%4d", i[j]), txtColor));
//                System.out.println("\n");
        }
        Attribute txtColor = TEXT_COLOR(40);
        System.out.print(colorize("�ҵ���ɫ", txtColor));
        return;
    }
*/

}



