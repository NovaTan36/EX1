package com.company;

import java.util.Scanner;

public class BinSearch {
    int[] number;
    int total;
    int target;

    public  BinSearch()
    {
        System.out.println("请输入数据的数量：");
        Scanner s=new Scanner(System.in);
        total=Integer.valueOf(s.next()).intValue();
        number=new int[total];
        System.out.println("请输入数据：");
        for (int i = 0; i < total; i++) {
            number[i]=Integer.valueOf(s.next()).intValue();
        }
        System.out.println("请输入要查找的数据：");
        target=Integer.valueOf(s.next()).intValue();
    }

    public void find()
    {
        int end=total-1,start=0;
        for (boolean flag = true ; flag;) {

            if(end-start>=0)
            {
                if(target<number[(end+start)/2])
                {
                    end=end/2;
                }
                else if(target>number[(end+start)/2])
                {
                    if ((end-start)/2<1)start++;
                    else start+=(end-start)/2;
                }
                else if (target==number[(end+start)/2])
                {
                    System.out.println("查找的数据在"+((end+start)/2+1));
                    flag=false;
                }
            }
            else
            {
                System.out.println("没有找到数据");
                flag=false;
            }

        }

    }

}
