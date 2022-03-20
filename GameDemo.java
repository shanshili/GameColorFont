/**
  **益智小游戏**
 GameA:文字、字体颜色
 GameB:文字、字体颜色、背景颜色
 GameC:文字、字体颜色、背景颜色、背景形状（图像化界面）
 */

//import game.option.GameOption;
//import javax.swing.text.AbstractDocument;
import java.util.Objects;
import java.util.Scanner;

public class GameDemo {
    public static int KeyColor,KeyOption,answer,num = 0;
    public static Scanner Response, ContinueGame, GameDiff;
    public static String  ReGame, CloseColor, Diff;
    public static String[] ColorFont = new String[7];
    public static String[] option = new String[2];
    public static String[] option2 = new String[3];
    public static String[] color = new String[7];

    public static void main(String[] args) {
        ColorFont[0]="黑色";
        ColorFont[1]="红色";
        ColorFont[2]="绿色";
        ColorFont[3]="黄色";
        ColorFont[4]="蓝色";
        ColorFont[5]="紫色";
        ColorFont[6]="灰色";
        option[0]="文字";
        option[1]="字体颜色";
//        option2[0]="字体颜色";
//        option2[1]="文字";
//        option2[2]="背景";
        color[0] = "\033[30;4m";//黑
        color[1] = "\033[31;4m";//红
        color[2] = "\033[32;4m";//绿
        color[3] = "\033[33;4m";//黄
        color[4] = "\033[34;4m";//蓝
        color[5] = "\033[35;4m";//紫
        color[6] = "\033[37;4m";//灰
        CloseColor ="\033[0m";
//        GameOption optionA = new GameOption("字体颜色");
//        GameOption optionB = new GameOption("文字");

        while(true) {
            System.out.println("选择游戏难度：\nA:※  \nB:※※\n\n\033[0;3mINF:查看游戏信息\033[0m\n\033[0;3m886:退出游戏\033[0m");
            GameDiff = new Scanner(System.in);
            Diff = GameDiff.nextLine();
            switch (Diff) {
                case "A":
                    GameA();
                    break;
                case "B":
                    System.out.println("GameB开发中，敬请期待！");
                    break;
                case "INF":
                    System.out.println("**益智小游戏**\n" +
                            " GameA:文字、字体颜色\n" +
                            " GameB:文字、字体颜色、背景颜色(开发中)\n" +
                            " GameC:文字、字体颜色、背景颜色、背景形状（图像化界面）(开发中)\n" +
                            " 22.3.20 build Demo1.0.0\n" +
                            " 作者：LCR\n\n");
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
                System.out.println(Content[cycle][0] +"."+ Content[cycle][1] + Content[cycle][3] + CloseColor);
            }
            System.out.println("4." + "都不对");
            Response = new Scanner(System.in);
            try
            {
                answer = Response.nextInt();
            }
            catch (Exception e) {
                System.out.println("输入错误，你应该输入一个数字:");
                continue;
            }

            value = JudgeAnswer(Content[answer-1], Title);
        } while (value != 1);
    }


/*
    public static void GameB(){
        for (j = 0; j < 3; j++) {
            for (i = 0; i < 7; i++) {
                System.out.println("请选择" + ColorFont[i] + "的" + option2[j] + "。");
                System.out.println("A." + "\033[40;31;4m" + "蓝色" + "\033[0m");//白底红
                System.out.println("B." + "\033[41;32;4m" + "黄色" + "\033[0m");//红底绿
                System.out.println("C." + "\033[42;33;4m" + "紫色" + "\033[0m");//绿底黄
                Response = new Scanner(System.in);
                answer = Response.nextLine();
                key = "A";
                if (Objects.equals(answer, key)) {
                    System.out.println("回答正确！");
                } else {
                    System.out.println("回答错误。");
                }
                System.out.println("是否继续？Y/N");
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
        Content[0] = String.valueOf(num);//序号
        Content[1] = color[j];//option颜色
        Content[2] = option[i];//option种类
        Content[3] = ColorFont[j2];//题目文字

        return Content;
    }
    public static int JudgeAnswer(String[] Respond,String[] Answer){
        /*
        Respond:
        0:序号
        1:颜色
        2:option种类
        3:文字
        Answer:
        0:题目
        1:option种类
        2:颜色
         */
        if(Objects.equals(Answer[1],option[0])){//题目问的是option[0]文字
            if(Objects.equals(Respond[3], Answer[2]))//判断选项文字是否为题目要求的文字
            {
                System.out.println("回答正确！");
            }
            else System.out.println("回答错误。");
        }
        if(Objects.equals(Answer[1], option[1])){//题目问的是option[1]字体颜色
            if(Objects.equals(Respond[1], Answer[3]))
            {
                System.out.println("回答正确！");
            }
            else System.out.println("回答错误。");
        }
        System.out.println("是否继续？Y/N");
        ContinueGame = new Scanner(System.in);
        ReGame = ContinueGame.nextLine();
        if (Objects.equals(ReGame, "Y")) {
            System.out.println("next");
            return 0;
        }
        else {
            return 1;
        }
    }
    public static String[] TitleGenerate(){
        String[] Title = new String[4];
        KeyOption = (int)(Math.random()*2);
        KeyColor = (int)(Math.random()*7);
        Title[0] = "请选择" + ColorFont[KeyColor] + "的" + option[KeyOption] + "。";
        Title[1] = option[KeyOption];
        Title[2] = ColorFont[KeyColor];
        Title[3] = color[KeyColor];
        return Title;
    }
}



