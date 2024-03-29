
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;


public class  Mazinger_김윤일
{
    public static void main(String[] args)
    {
        JFrame frame = new MazingerFrame();
        frame.setVisible(true);  
    }
}

class MazingerFrame extends JFrame
{  
    
    public MazingerFrame()
   {  

        setTitle("MazingerFrame");
        setSize(900,900);
        setResizable(false);
        addWindowListener(new WindowAdapter()
        {  
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        } );
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        int screenHeight = d.height;
        int screenWidth = d.width;
        setLocation(250,140);
        setUndecorated(true);
        setBackground(new Color(0,0,0,0));
       
        Container contentPane = getContentPane();
        contentPane.add(new MazingerPanel());
    }
}

class MazingerPanel extends JPanel implements MouseListener
{   
   



    //ImageIcon image;
    Color lightGray = new Color(118,141,136);
    Color gray = new Color(25,34,38);
    Color darkGray = new Color(16,16,16);
    Color black = new Color(0, 0, 0);

    Color blue = new Color(75,92,145);
    Color darkblue = new Color(30,54,102); //입 명암

    Color darkPurple = new Color(128,28,60); //미간 딱 하나있는 보라
    

    Color red = new Color(213,67,41); 
    Color darlRed = new Color(134,29,32);

    Color yellow = new Color(239,229,95);
    Color darkYellow = new Color(205,225,50);

    Color skyBlue = new Color(80,167,222);
    Color skyBlue2 = new Color(159,215,239);

BufferedImage image;
    public MazingerPanel()
    {        
        
        // try {
        // image = ImageIO.read(new File("마징가.png"));
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        //image = new ImageIcon("마징가0.jpg");
        //setBackground(new Color(0,0,0,0));
        //setBackground(new Color(102,178,255)); //투명 배경
        String s1 =("dkd");
        this.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                System.out.println(x+","+y);
            }
        });
    }
    public void paintComponent(Graphics g)
    {          
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, this);
        }
        
        //배경 그라데이션
        Graphics2D g2 = (Graphics2D) g;
        GradientPaint gp = new GradientPaint(600, 250,skyBlue, 600, 550,skyBlue2);

        g2.setPaint(gp);
        g2.fillRect(0, 0, 900, 900);
        g.setColor(Color.white);
       
        
        Font f1 = new Font("SansSerif",Font.BOLD,16);
        Font f2 = new Font("SansSerif",Font.BOLD,20);
        Font f3 = new Font("SansSerif",Font.BOLD + Font.ITALIC,16);

        FontMetrics fm1 = g.getFontMetrics(f1);
        FontMetrics fm2 = g.getFontMetrics(f2);
        FontMetrics fm3 = g.getFontMetrics(f3);

        String s1 = "안녕하세요";
        String s2 = "컴퓨터공학과";
        String s3 = "21학번 김윤일 입니다.";

        int w1 = fm1.stringWidth(s1);
        int w2 = fm2.stringWidth(s2);
        int w3 = fm3.stringWidth(s3);



        //g.drawLine(0, 10, 510, 10);
        
        //Dimension d = getSize();
        //g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
        //drawGuideline(g);
        drawWig(g);
        drawBody(g);
        drawArm(g);
        drawHead(g);
        g.setFont(f1);
        g.drawString(s1,0,40);
        g.setColor(Color.green);
        g.setFont(f2);
        g.drawString(s2,w1,40);
        g.setFont(f3);
        g.setColor(Color.orange);
        g.drawString(s3,w1+w2,40);

    }
    
    public void drawHead(Graphics g)
    {
        g.setColor(black);    
        g.fillPolygon(new int[]{299,310,339,446,482,504,495,487,471,461,459,460,468,465,447,245,271,269,271}, new int[]{130,130,163,171,137,149,284,336,347,386,513,518,525,552,565,450,369,373,320},19);
       // g.fillPolygon(new int[]{18,139,156,67,-3}, new int[]{419,496,683,767,723}, 5);
        //머리전체 기본
        //왼귀
        g.setColor(lightGray);
        int[] headX = {212,240,248,256,264,271,276,286,304,326,345,342,307,287,270,253,237,225,212};
        int[] headY = {119,226,233,243,253,262,269,262,246,236,229,185,159,33,37,43,54,69,87,116};
        g.fillPolygon(headX, headY, headX.length);
        g.setColor(gray);
        g.fillPolygon(new int[]{311,317,327,330,333,338,329,314}, new int[]{130,134,136,144,150,157,167,155}, 8);

        //오귀
        g.setColor(lightGray);
        g.fillPolygon(new int[]{431,445,479,522,541,559,571,579,586,537,519,505,494,430},new int[]{239,195,171,60,71,93,110,121,146,246,260,274,284,240},14);
        g.setColor(gray);
        g.fillPolygon(new int[]{447,453,459,463,474,484,473,455}, new int[]{170,160,151,141,140,137,166,178}, 8);

        //이마
        g.setColor(darkPurple);
        g.fillPolygon(new int[]{350,384,405,431,410,385,366,351}, new int[]{207,204,206,212,218,222,212,208}, 8);
        g.setColor(red);
        g.fillPolygon(new int[]{348,350,358,366,372,375,392,397,405,413,426,429,387,366}, new int[]{209,222,226,232,240,249,251,240,234,230,230,216,224,214},14 );
        g.fillPolygon(new int[]{349,366,386,409,425,439,435,423,414,414,419,432,408,389,365,350,350,360,366,366,357,348}, new int[]{184,180,180,182,186,191,194,192,193,196,201,208,204,202,202,204,202,198,193,190,187,187},22 );
        g.setColor(new Color(170,190,223));
        g.fillPolygon(new int[]{330,338,348,361,378,390,416,434,446,453,440,416,390,367,347},new int[]{168,157,150,143,140,140,147,159,169,181,190,182,178,178,181},15);
        g.setColor(red);
        g.fillPolygon(new int[]{378,381,389,396,404,407}, new int[]{138,133,132,132,137,141},6);
        g.fillPolygon(new int[]{386,394,398},new int[]{130,78,131},3);

        //눈
        g.setColor(yellow);
        g.fillPolygon(new int[]{345,305,331,360},new int[]{233,248,263,250},4);
        g.fillPolygon(new int[]{427,407,435,460},new int[]{240,253,269,263},4);

        //뿔
        g.fillPolygon(new int[]{273,114,273,276,279,280,278},new int[]{282,286,320,318,309,297,286},7);
        g.fillPolygon(new int[]{494,640,485,481,483,487}, new int[]{298,338,336,324,311,302}, 6);

        //코
        g.setColor(blue);
        g.fillPolygon(new int[]{331,334,349,365},new int[]{264,302,304,254}, 4);
        g.fillPolygon(new int[]{366,368,381,397},new int[]{254,285,286,258}, 4);
        g.fillPolygon(new int[]{401,404,420,433},new int[]{258,309,310,273}, 4);

        g.setColor(darkblue);
        g.fillPolygon(new int[]{302,280,285,289,333,330},new int[]{251,268,273,282,300,264},6 );
        g.fillPolygon(new int[]{365,350,366},new int[]{254,302,285}, 3);
        g.fillPolygon(new int[]{367,350,405,381},new int[]{286,304,310,288}, 4);
        g.fillPolygon(new int[]{398,382,404},new int[]{257,285,308}, 3);
        g.fillPolygon(new int[]{436,423,478,483,491,465,436},new int[]{272,309,296,288,284,265,271}, 7);
        
        //입
        g.setColor(lightGray);
        g.fillPolygon(new int[]{277,283,284,334,415,481,488,493,494,486,479,418,334,288,287}, new int[]{271,279,286,307,318,302,293,292,285,286,298,311,301,282,277},15);
        g.fillPolygon(new int[]{334,337,401,415}, new int[]{309,383,394,318}, 4);
        g.setColor(new Color(47,66,72));
        g.fillPolygon(new int[]{275,281,282,332,335,274,279,280,279},new int[]{271,277,286,311,379,322,313,298,286},9);
        g.fillPolygon(new int[]{416,405,487,481,480,484,495,488,481}, new int[]{318,389,337,330,318,307,294,295,303}, 8);

         
         //g.fillPolygon(new int[]{}, new int[]{}, );
        //입명암
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(black);
        g2d.setStroke(new BasicStroke(3f));
        g.drawLine(287,299,287,327);
        g.fillPolygon(new int[]{295,300,299,295}, new int[]{299,301,339,334}, 4);
        g.fillPolygon(new int[]{305,305,312,312}, new int[]{305,344,351,308}, 4);
        g.fillPolygon(new int[]{319,319,327,326}, new int[]{310,357,363,314}, 4);
        g.fillPolygon(new int[]{344,358,355,345}, new int[]{317,318,376,375}, 4);
        g.fillPolygon(new int[]{368,384,379,365}, new int[]{320,323,380,376},4);
        g.fillPolygon(new int[]{393,384,396,406}, new int[]{322,381,384,324},4);
        g.fillPolygon(new int[]{426,416,425,435}, new int[]{325,371,366,323},4);
        g.fillPolygon(new int[]{441,433,442,450}, new int[]{321,362,359,319},4);
        g.fillPolygon(new int[]{454,448,458,465}, new int[]{317,353,347,316},4);
        g.fillPolygon(new int[]{469,466,473,477}, new int[]{316,342,337,312},4);

        //투턱
        g.setColor(gray);
        g.fillPolygon(new int[]{286,306,366,332}, new int[]{338,372,420,379},4);
        g.fillPolygon(new int[]{368,431,458,402}, new int[]{421,390,358,394}, 4);
        g.setColor(new Color(47,66,72));
        g.fillPolygon(new int[]{340,396,367}, new int[]{386,395,419},3);
        
       //목
        g.setColor(lightGray);
        g.fillPolygon(new int[]{272,270,280}, new int[]{323,365,334}, 3);
        g.fillPolygon(new int[]{283,246,257,266,277,305}, new int[]{338,448,449,452,456,374}, 6);
        g.fillPolygon(new int[]{306,280,298,321,339,356,365}, new int[]{375,457,465,475,484,494,421}, 7);
        g.fillPolygon(new int[]{367,361,379,399,417,441,436,429}, new int[]{421,498,509,523,539,564,524,393}, 8);
        g.fillPolygon(new int[]{433,434,437,445,456,463,462,459,458,457,459}, new int[]{391,450,503,559,549,536,522,517,492,435,365}, 11);
        g.fillPolygon(new int[]{462,461,470}, new int[]{356,383,351}, 3);

        //팔
        g.setColor(darkGray);
        g.fillPolygon(new int[]{1,32,67,100,121,137,143,136,119,96,83,83,71,54,33,15,1}, new int[]{435,439,455,479,508,553,605,651,697,732,742,727,706,683,663,649,640},17);
        g.fillPolygon(new int[]{582,596,666,671,672,673,673,669,665,660,682,693,702,712,716,720,717,708,697,680,601,584}, new int[]{576,589,706,728,750,778,807,826,847,867,850,833,812,792,764,742,708,677,653,629,579,576},22);
        g.setColor(lightGray);
        g.fillPolygon(new int[]{-1,20,43,57,61,19,-1}, new int[]{684,698,718,734,741,897,897},7);
        g.fillPolygon(new int[]{681,664,658,655,650,682}, new int[]{852,863,871,883,897,898},6);
        g.setColor(black);
        g.drawPolygon(new int[]{681,664,658,655,650,682}, new int[]{852,863,871,883,902,905},6);
        
        //뒷날개
        g.setColor(red);
            int[] wigX = {542,562,584,609,630,684,703,728,752,779,798,821,847,873,887,902,905,874,855,837,822,830,837,842,844,840,830,815,801,782,765,749,732,719,718,712,699,690,682,601,590,580,562,544};
            int[] wigY = {548,544,536,523,511,486,473,458,440,424,407,387,359,328,307,287,695,768,818,855,876,850,821,790,752,717,691,684,687,696,709,721,734,743,712,684,654,639,629,577,573,573,562,549};
          g.fillPolygon(wigX,wigY,wigX.length);
          g.setColor(black);
          g.drawPolygon(wigX, wigY, wigX.length);

        g.setColor(red);
            int[] wig1X = {106,54,16,-2,-2,17,32,49,62,64,86};
            int[] wig1Y = {442,408,383,369,435,435,438,443,451,452,448};
        g.fillPolygon(wig1X,wig1Y,wig1X.length); 
        g.setColor(black);
        g.drawPolygon(wig1X, wig1Y, wig1X.length);
 
        //왼찌
        g.setColor(new Color(16,16,16));
        g.fillPolygon(new int[]{70,91,120,148,237,247,278,306,332,358,385,413,434,448,462,474,481,484,485,485,480,475,458,433,408,389,360,331,307,265,235,210,20,60,63,83,94,112,129,139,144,143,136,124,106,88,66}, 
        new int[]{454,447,443,441,448,449,460,470,483,498,515,537,558,576,608,642,676,705,740,774,801,818,813,813,817,820,827,836,845,863,881,897,897,752,748,744,737,712,674,644,613,580,543,511,482,468,452},47);
        
        //오찌
        g.fillPolygon(new int[]{443,455,464,466,485,507,523,546,564,580,597,665,670,671,672,665,657,647,572,559,547,530,507,477,483,486,487,486,482,477,471,463,451,444}, new int[]{567,555,539,525,527,535,541,551,563,576,591,703,733,770,803,841,872,896,897,882,869,854,837,819,796,771,750,721,685,652,628,605,578,567},34);

        //앞날개
        g.setColor(red);
        g.fillPolygon(new int[]{433,212,139,1,185,291,423,431,437,442,448,448}, new int[]{769,691,394,289,362,538,592,610,632,663,712,759},12);
        g.fillPolygon(new int[]{510,520,591,641,655,770,697,649,639,532}, new int[]{616,604,603,487,477,520,541,790,801,786},10);
        g.setColor(black);
        g.drawPolygon(new int[]{510,520,591,641,655,770,697,649,639,532}, new int[]{616,604,603,487,477,520,541,790,801,786},10);
        g.drawLine(647,790,542,776);
        g.drawLine(542,776,521,606);
        g.drawLine(600,603,658,478);
        g.drawLine(591,603,598,603);


        g.drawPolygon(new int[]{433,212,139,1,185,291,423,431,437,442,448,448},new int[]{769,691,394,289,362,538,592,610,632,663,712,759},12); //왼쪽날개 선
        g.drawLine(3,290,146,387);
        g.drawLine(146,387,229,680);
        g.drawLine(229,680,444,758);

        //몸통
        g.setColor(Color.white);
        g.fillPolygon(new int[]{209,226,252,272,295,323,352,386,412,442,470,488,510,530,553,572}, new int[]{897,886,871,862,852,841,833,824,816,815,819,827,841,855,876,896},16);
        
        


       // Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.black);
        g2d.setStroke(new BasicStroke(4f));
        //g.drawLine(212,119,240,224);
    

       /*  g.setColor(new Color(171,201,195));
        g.fillPolygon(new int[] {}, new int[] {}, nPoints:10);
        */

        // //뿔
        // g.setColor(yellow);
        // int[] hornX1 = {463, 414, 460, 463};
        // int[] hornY1 = {311, 310, 292, 311};
        // g.fillPolygon(hornX1,hornY1,hornX1.length);

        // g.setColor(yellow);
        // int[] hornX2 = {578, 625, 574, 578};
        // int[] hornY2 = {293, 280, 274, 293};
        // g.fillPolygon(hornX2,hornY2,hornX2.length);

        // g.setColor(red);
        // int[] senterHornX1 = {514,527,530,530,543,542,536,530,523,517,507,505,500,495,490,486,486,488,504,512};
        // int[] senterHornY1 = {305,304,300,283,266,260,250,245,240,240,200,240,242,247,252,260,270,275,288,305};
        // g.fillPolygon(senterHornX1,senterHornY1,senterHornX1.length);

        // g.setColor(skyBlue);
        // int[] senterHornX2 = {488,500,510,520,530,540,543,543,538,536,532,528,520,510,505,500,490,486,485,484,488};
        // int[] senterHornY2 = {274,276,276,276,275,270,268,260,250,248,245,243,239,240,239,242,250,259,262,265,274};
        // g.fillPolygon(senterHornX2,senterHornY2,senterHornX2.length);

        // g.setColor(gray);
        // int[] headX3 = {460,463,471,472,474,477,480,482,483,510,550,562,562,570,573,570,577,573,561,561,555,542,524,503,488,478,473};
        // int[] headY3 = {290,311,314,332,334,335,330,326,336,368,366,332,313,321,319,301,294,273,291,306,318,334,338,336,327,316,300};
        // g.fillPolygon(headX3,headY3,headX3.length);

        // g.setColor(yellow);
        // int[] eyeX1 = {504,506,490,482};
        // int[] eyeY1 = {305,310,310,302};
        // g.fillPolygon(eyeX1,eyeY1,eyeX1.length);

        // g.setColor(yellow);
        // int[] eyeX2 = {534,531,547,552};
        // int[] eyeY2= {300,305,303,294};
        // g.fillPolygon(eyeX2,eyeY2,eyeX2.length);

        // g.setColor(lightGray);
        // int[] headX1 = {427,420,437,475,511,507,486,470,457,450,441,434,428};
        // int[] headY1 = {215,226,268,303,305,290,273,225,226,225,224,222,216};
        // g.fillPolygon(headX1,headY1,headX1.length);

        // g.setColor(lightGray);
        // int[] headX2 = {529,528,542,547,558,566,574,582,591,594,590,574,562};
        // int[] headY2 = {303,284,268,216,215,213,210,204,195,204,243,272,291};
        // g.fillPolygon(headX2,headY2,headX2.length);

        // g.setColor(lightGray);
        // int[] headX4 = {474,481,507,543,563,561,558,544,511,503,482,474};
        // int[] headY4 = {302,324,342,341,306,285,304,331,334,333,318,302};
        // g.fillPolygon(headX4,headY4,headX4.length);

        // g.setColor(lightGray);
        // int[] headX5 = {482,484,510,506};
        // int[] headY5 = {327,337,368,343};
        // g.fillPolygon(headX5,headY5,headX5.length);

        // g.setColor(lightGray);
        // int[] headX6 = {509,542,545,513};
        // int[] headY6 = {344,342,365,367};
        // g.fillPolygon(headX6,headY6,headX6.length);


        // g.setColor(darkPurple);
        // int[] faceX1 = {504,518,531,534,521};
        // int[] faceY1 = {305,337,338,301,303};
        // g.fillPolygon(faceX1,faceY1,faceX1.length);

        // g.setColor(darkPurple);
        // int[] faceX2 = {511,514,519,516};
        // int[] faceY2 = {348,363,364,347};
        // g.fillPolygon(faceX2,faceY2,faceX2.length);

        // g.setColor(darkPurple);
        // int[] faceX3 = {521,524,529,526};
        // int[] faceY3 = {348,363,364,347};
        // g.fillPolygon(faceX3,faceY3,faceX3.length);

        // g.setColor(darkPurple);
        // int[] faceX4 = {531,534,539,536};
        // int[] faceY4 = {348,363,363,347};
        // g.fillPolygon(faceX4,faceY4,faceX4.length);

        // g.setColor(darkPurple);
        // int[] faceX5 = {491,502,505,505};
        // int[] faceY5 = {339,354,359,346};
        // g.fillPolygon(faceX5,faceY5,faceX5.length);

        // g.setColor(darkPurple);
        // int[] faceX6 = {546,549,556};
        // int[] faceY6 = {343,358,332};
        // g.fillPolygon(faceX6,faceY6,faceX6.length);

        // g.setColor(darkPurple);
        // int[] faceX7 = {420,428,433,438,444,461,472,459,457,440,430,424,430,440,443,457,478,480};
        // int[] faceY7 = {228,231,234,235,235,235,233,236,244,246,240,238,240,246,260,272,287,302};
        // g.drawPolyline(faceX7,faceY7,faceX7.length);

        // g.setColor(darkPurple);
        // int[] faceX8 = {552,551,568,570,582,592,582,580,594,580,566,545};
        // int[] faceY8 = {293,280,257,238,233,220,233,220,205,220,226,225};
        // g.drawPolyline(faceX8,faceY8,faceX8.length);


    }
    public void drawBody(Graphics g){
    //     // 몸통
    //     g.setColor(Color.black);
    //     int[] bodyX = {278, 280, 284, 288, 295, 302, 320, 340, 370, 390, 413, 429, 450, 490, 530, 570, 610, 620, 640, 660, 680, 700, 720, 741, 750, 710, 671, 654, 654, 620, 560, 555, 530, 526, 458, 278};
    //     int[] bodyY = {300, 290, 280, 270, 260, 250, 239, 231, 230, 234, 246, 230, 214, 198, 193, 195, 210, 200, 188, 180, 177, 180, 190, 210, 226, 340, 360, 380, 390, 450, 460, 466, 466, 460, 460, 300};
    //     g.fillPolygon(bodyX, bodyY, bodyX.length);

    //     //가슴 브이
    //     g.setColor(darlRed);
    //     int[] vX1 = {430, 470, 510, 520, 528, 528, 522, 526, 460, 411, 418, 430};
    //     int[] vY1 = {420, 446, 440, 442, 450, 460, 462, 470, 476, 440, 430, 420};
    //     g.fillPolygon(vX1,vY1,vX1.length);

    //     g.setColor(darlRed);
    //     int[] vX2 = {552, 558, 586, 600, 630, 640, 660, 690, 627, 560, 552};
    //     int[] vY2 = {448, 434, 430, 430, 399, 390, 384, 379, 455, 464, 448};
    //     g.fillPolygon(vX2,vY2,vX2.length);

    //     g.setColor(red);
    //     int[] vX3 = {412,466,520,526,527,520,511,472,424};
    //     int[] vY3 = {429,462,460,459,451,441,437,445,413};
    //     g.fillPolygon(vX3,vY3,vX3.length);

    //     g.setColor(red);
    //     int[] vX4 = {584,582,558,553,618,692,653,606};
    //     int[] vY4 = {436,428,432,447,438,378,386,434};
    //     g.fillPolygon(vX4,vY4,vX4.length);

    }

     public void drawArm(Graphics g){
    //     //오른팔뚝
    //     g.setColor(lightGray);
    //     int[] arm1X = {316,330,340,350,360,370,376,378,370,370,366,316};
    //     int[] arm1Y = {306,302,306,311,320,330,340,350,360,366,370,306};
    //     g.fillPolygon(arm1X, arm1Y, arm1X.length);
    //     //오른주먹
    //     g.setColor(Color.darkGray);
    //     int[] armX1 = {170, 175, 180, 190, 192, 190, 190, 192, 200, 210, 220, 240, 270, 290, 310, 330, 346, 360, 366, 365, 370, 400, 423, 420, 408, 405, 400, 394, 384, 360, 350, 334, 331, 320, 314, 300, 293, 290, 270, 240, 200, 182, 169, 170};
    //     int[] armY1 = {470, 450, 438, 420, 410, 400, 390, 370, 350, 336, 323, 310, 300, 300, 303, 312, 330, 348, 360, 370, 374, 390, 412, 430, 440, 470, 484, 490, 490, 507, 513, 500, 490, 489, 510, 515, 520, 531, 535, 534, 526, 510, 490, 470};
    //     g.fillPolygon(armX1, armY1, armX1.length);

    //     g.setColor(gray);
    //     int[] pX11 = {187,186,180,183,185,202,271,280,289,291,292,300,309,318,332,403,406,418,423,402,359,360,326,318,314,301,288,290,279,265,242,241,252,239,230,225,225,213,203,202,203,215,205,196,194};
    //     int[] pY11 = {454,461,482,493,499,516,534,533,530,524,519,516,511,490,489,473,436,429,412,392,382,381,374,382,380,376,387,409,413,382,395,418,442,448,442,426,410,414,430,446,462,474,485,471,452};
    //     g.fillPolygon(pX11,pY11,pX11.length);

    //     //왼팔뚝
    //     g.setColor(lightGray);
    //     int[] arm2X = {716, 700, 690, 680, 674, 672, 675, 670, 670, 680, 685, 694, 716};
    //     int[] arm2Y = {234, 236, 239, 249, 260, 270, 280, 287, 300, 302, 310, 316, 234};
    //     g.fillPolygon(arm2X, arm2Y, arm2X.length);
    //     //횐 주먹
    //     g.setColor(gray);
    //     int[] armX2 = {928, 927, 922, 911, 898, 880, 878, 875, 870, 860, 842, 829, 810, 800, 780, 765, 740, 720, 704, 694, 693, 695, 700, 690, 676, 665, 681, 690, 703, 720, 730, 740, 750, 763, 770, 770, 768, 779, 789, 800, 810, 814, 821, 839, 871, 900, 920, 928};
    //     int[] armY2 = {390, 380, 370, 350, 330, 314, 300, 290, 278, 260, 240, 230, 222, 217, 212, 210, 215, 230, 250, 280, 300, 320, 334, 340, 350, 370, 400, 418, 440, 442, 446, 449, 457, 455, 445, 438, 430, 430, 440, 450, 449, 450, 460, 460, 450, 439, 418, 390};
    //     g.fillPolygon(armX2, armY2, armX2.length);

    //     g.setColor(darkGray);
    //     int[] pX15 = {730,756,789,797,802,829,822,818,832,833,842,862,850,854,866,883,877,882,889,905,896,890,895,910,831,749,730};
    //     int[] pY15 = {330,340,321,305,298,307,334,343,348,337,302,320,350,351,322,329,362,365,334,347,387,404,406,354,287,269,312};
    //     g.fillPolygon(pX15,pY15,pX15.length);

    //     g.setColor(darkPurple);
    //     int[] pX1 = {350,359,370,384,394,400,404,401,388,390,404,407,419,423,416,410,398,404,396,397,408,401,364,352,364,358,331,333,346,350};
    //     int[] pY1 = {512,507,500,490,489,484,470,472,464,460,468,440,430,411,428,433,421,407,418,405,398,390,369,396,424,459,490,499,510,512};
    //     g.fillPolygon(pX1,pY1,pX1.length);

    //     g.setColor(deepPurple);
    //     int[] pX2 = {342,388,400,404,403,392,384,362,350,341};
    //     int[] pY2 = {504,464,471,469,479,489,490,506,511,505};
    //     g.fillPolygon(pX2,pY2,pX2.length);

    //     g.setColor(deepPurple);
    //     int[] pX3 = {404,408,410,400,404,400,394,390};
    //     int[] pY3 = {466,439,435,424,433,446,453,457};
    //     g.fillPolygon(pX3,pY3,pX3.length);

    //     g.setColor(darkPurple);
    //     int[] pX5 = {363,365,357,345,337,329,314,297,275,254,240,230,218,210,202,197,192,190,190,190,190,191,194,203,214,219,223,242,255,264,268,282,306,325,338,348,353,358,362};
    //     int[] pY5 = {370,360,344,329,321,311,303,300,300,306,310,317,326,335,346,358,370,382,386,391,398,406,409,401,389,384,379,370,365,361,358,358,355,358,362,367,368,370,374};
    //     g.fillPolygon(pX5,pY5,pX5.length);

    //     g.setColor(lightGray);
    //     int[] pX4 = {362,351,343,336,326,317,295,282,274,254,238,227};
    //     int[] pY4 = {370,354,350,345,338,334,332,334,336,341,349,357};
    //     g.drawPolyline(pX4,pY4,pX4.length);

    //     g.setColor(lightGray);
    //     int[] pX6 = {408,397,376,363,358,363,376,365,359,363,382,388,391,397,391};
    //     int[] pY6 = {397,405,418,414,411,414,418,423,450,460,468,463,436,422,409};
    //     g.drawPolyline(pX6,pY6,pX6.length);

    //     g.setColor(darkPurple);
    //     int[] pX7 = {360,349,337,319,308,294,285,272,264,250,232,212,194,191,183,177,173,169,170,169,178,175,178,189,197,210,251,297,330,352,358};
    //     int[] pY7 = {376,370,369,366,364,363,363,364,364,371,378,394,407,417,431,446,458,470,486,489,502,487,468,442,426,408,379,372,373,378,379};
    //     g.fillPolygon(pX7,pY7,pX7.length);

    //     g.setColor(darkPurple);
    //     int[] pX8 = {272,261,269,282,288,279,290,303,312,316,318,310,322,332,341,344,334,330,342,358,363,351,343,334,316,308,283,289,282,273,243,206,187,201,210,221,234,250,259,272};
    //     int[] pY8 = {534,529,518,518,518,511,498,509,510,501,488,479,469,478,479,474,465,458,450,452,422,396,385,387,374,393,417,412,408,426,442,478,514,526,526,529,532,534,534,534};
    //     g.fillPolygon(pX8,pY8,pX8.length);

    //     g.setColor(deepPurple);
    //     int[] pX9 = {188,199,209,230,240,247,259,271,271,262,266,270,286,279,290,303,310,314,314,319,310,322,331,341,344,334,330,343,350,335,316,300,281,249,201};
    //     int[] pY9 = {514,526,529,530,533,535,536,535,533,530,518,518,517,512,498,509,511,507,506,490,479,467,477,478,474,465,457,448,449,438,455,446,470,498,488};
    //     g.fillPolygon(pX9,pY9,pX9.length);

    //     g.setColor(lightGray);
    //     int[] pX10 = {363,343,334,316,308,336,343,336,308,286,319,286,288,282,274,298,274,246,275,306,275,246,208,244,271,244,208,188,202,220,250};
    //     int[] pY10 = {423,386,387,374,393,439,448,439,393,414,470,414,411,408,426,451,426,442,476,495,476,442,478,509,516,509,478,514,525,528,534};
    //     g.drawPolyline(pX10,pY10,pX10.length);

    //     g.setColor(darkPurple);
    //     int[] pX12 = {676,690,686,673,686,702,714,730,743,750,763,770,767,765,764,750,759,771,767,763,773,786,794,780,788,806,813,800,814,834,838,845,901,916,892,901,879,875,834,826,793,782,758,729,777,796,830,854,878,889,904,911,918,925,922,918,920,922,929,920,911,902,889,879,878,875,872,868,862,854,843,837,831,826,814,803,791,782,774,766,742,738,734,723,716,713,709,704,699,694,693,693,693,693,693,694,694,697,699,678};
    //     int[] pY12 = {349,358,367,381,407,440,441,446,451,458,455,442,430,422,417,411,391,400,412,418,415,402,415,428,432,421,439,448,448,445,453,459,439,426,398,388,359,366,335,338,321,310,341,330,309,305,312,320,330,339,351,364,375,387,402,418,418,410,390,365,350,338,322,314,302,293,284,277,263,254,243,237,232,229,224,218,215,213,211,210,214,215,218,226,231,240,244,251,262,279,287,293,302,305,311,314,319,328,334,350};
    //     g.fillPolygon(pX12,pY12,pX12.length);

    //     g.setColor(darkGray);
    //     int[] pX13 = {860,842,830,818,806,799,776,761,747,737,730,758,772,786,794,814,826,842,847};
    //     int[] pY13 = {306,302,301,298,296,296,296,297,303,310,317,308,305,303,302,304,304,306,306};
    //     g.fillPolygon(pX13,pY13,pX13.length);

    //     g.setColor(lightGray);
    //     int[] pX14 = {775,820,808,765,759,754,742,737,734,730,723,722,719,714,710,709,707,706,703,699,676,690,686,673,701,701,715,701,701,701,715,734,743,749,762,770,764,750,764,770,753,714,750,742,716,689,686,714,748,742,740,755,729,698,729,755,781,790,744,790,824,773,764,770,760,750,760,770,764,774,823,834,854,847,814,784,814,847,854,833,825,786,825,833,854,880,875,828,813,828,875,879,874,879,899,891,834,891,914};
    //     int[] pY14 = {273,277,275,275,278,280,285,289,290,293,299,302,306,311,315,318,322,326,328,334,348,358,368,381,438,430,418,430,430,438,440,447,450,456,454,443,417,412,417,443,434,418,411,386,372,358,369,418,413,385,369,342,330,334,330,342,310,319,394,319,337,413,418,401,392,411,392,401,418,413,339,335,351,369,406,430,406,369,351,337,355,402,355,337,350,371,385,436,446,436,385,370,366,359,388,400,445,400,423};
    //     g.drawPolyline(pX14,pY14,pX14.length);
     }

     public void drawWig(Graphics g) {

    //     g.setColor(Color.orange);
    //     int[] fireX = {459,463,418,421,373,407,318,385,277,356,286,362,315,437,624,670,749,661,731,624,646,588,569,558,527,509,486,482,458,462};
    //     int[] fireY = {125,126,66,116,78,135,117,151,174,184,215,211,245,257,227,184,161,153,102,126,70,114,51,110,43,111,42,106,46,123};
    //     g.fillPolygon(fireX,fireY,fireX.length);

    //     g.setColor(darkYellow);
    //     int[] wig1X = {441,434,430,420,410,400,390,384,382,390,395,400,410,420,454,454,553,554,593,600,610,615,620,624,623,618,617,610,603,590,580,570,561,558,441};
    //     int[] wig1y = {160,156,153,151,151,154,160,170,200,211,216,218,223,224,200,190,180,183,200,198,193,188,180,170,160,143,140,134,130,126,127,132,140,145,160};
    //     g.fillPolygon(wig1X,wig1y,wig1X.length);

    //     g.setColor(darlRed);
    //     int[] wigX = {0, 20, 380, 382, 385, 390, 400, 410, 420, 430, 442, 460, 490, 507, 530, 560, 580, 590, 600, 610, 620, 625, 1040, 1040, 600, 590, 580, 570, 560, 550, 540, 530, 520, 511, 496, 480, 467, 460, 452, 441, 430, 419, 400, 0};
    //     int[] wigY = {240, 240, 200, 196, 194, 190, 186, 185, 186, 188, 190, 192, 196, 200, 187, 174, 166, 163, 160, 158, 161, 167, 94, 75, 146, 146, 147, 146, 144, 140, 135, 131, 130, 130, 130, 134, 140, 143, 150, 160, 166, 170, 174, 221};
    //     g.fillPolygon(wigX,wigY,wigX.length);

    //     g.setColor(yellow);
    //     int[] wig3X = {384,442,440,430,422,410,400,390,384,384};
    //     int[] wig3Y = {175,168,159,154,152,150,154,160,170,175};
    //     g.fillPolygon(wig3X,wig3Y,wig3X.length);

    //     g.setColor(yellow);
    //     int[] wig4X = {617,560,558,563,572,583,600,613};
    //     int[] wig4Y = {142,153,143,138,130,126,128,137};
    //     g.fillPolygon(wig4X,wig4Y,wig4X.length);

    //     g.setColor(red);
    //     int[] wig2X = {0,442,464,490,502,516,541,556,574,1040,1040,617,606,590,581,568,553,530,520,510,500,482,470,460,454,447,440,434,423,414,398,381,0};
    //     int[] wig2Y = {230,176,165,154,150,148,150,155,158,82,75,143,145,146,148,145,142,133,130,130,130,133,139,143,148,154,160,163,168,172,174,176,221};
    //     g.fillPolygon(wig2X,wig2Y,wig2X.length);
     }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        System.out.println(x+","+y);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
