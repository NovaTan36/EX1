package com.company;

import java.util.Scanner;

public class BadChocolate {
    int[] bad =new int[2];
    int bBelow,bTop,bLeft,bRight;
    Scanner s=new Scanner(System.in);//输入变量
    public BadChocolate()
    {
        int x,y;
        System.out.println("请输入巧克力的大小(格式：x y)：");
        x=s.nextInt();
        y=s.nextInt();
        System.out.println("请输入坏巧克力的位置(格式：x y)：");
        boolean flag;
        do {
            bad[0] = s.nextInt();
            bad[1] = s.nextInt();
            if (bad[0]>0&&bad[0]<x&&bad[1]>0&&bad[1]<y)
                flag=false;
            else
            {
                System.out.println("超出巧克力范围，请重新输入");
                flag=true;
            }
        }while(flag);
        bTop=y-bad[1];
        bBelow=bad[1]-1;
        bLeft=bad[0]-1;
        bRight=x-bad[0];
        start();
    }

    public void print()
    {
        int H=bTop+bBelow+1,V=bLeft+bRight+1;
        for(int i=0;i<H;i++)
        {
            for (int j=0;j<V;j++)
            {
                if (j==bLeft&&i==bTop)
                    System.out.print("B ");
                else
                    System.out.print("0 ");
            }
            System.out.println();
        }
    }

    public void playerToDo()
    {
        boolean flag=true;
        do {
            int d=s.nextInt();
            switch (d)
            {
                case 8:
                    if(bTop!=0)
                    {
                        bTop--;
                        flag=false;
                    }
                    else
                    {
                        noDo();
                    }
                break;
                case 4:
                    if (bLeft!=0)
                    {
                        bLeft--;
                        flag=false;
                    }
                    else
                    {
                        noDo();
                    }
                break;
                case 2:
                    if (bBelow!=0)
                    {
                        bBelow--;
                        flag=false;
                    }
                    else
                    {
                        noDo();
                    }
                break;
                case 6:
                    if (bRight!=0)
                    {
                        bRight--;
                       flag=false;
                    }
                    else
                    {
                        noDo();
                    }
                break;
                default:
                    System.out.println("未知操作，请重新输入");
                    break;
            }
        }while(flag);
    }
    private void computerToDo()
    {
        if (bLeft!=0)bLeft--;
        else if (bTop!=0)bTop--;
        else if (bRight!=0)bRight--;
        else if (bBelow!=0)bBelow--;
    }
    private void noDo()
    {
        System.out.println("该边已经没有巧克力了，请重新输入");
    }
    private boolean end()
    {
        return bLeft == 0 && bTop == 0 && bRight == 0 && bBelow == 0;
    }
    private void result(String s)
    {
        System.out.println("你"+s+"了");
    }
    private void start()
    {
        System.out.println("4、8、6、2分别表示取走左、上、右、下边的巧克力");
        while (true)
        {
            print();
            playerToDo();
            if (end())
            {
                result("赢");
                break;
            }
            print();
            System.out.println();
            computerToDo();
            if (end())
            {
                result("输");
                break;
            }
            System.out.println();
        }
    }
}
