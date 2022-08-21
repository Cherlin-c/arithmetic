package com.scl.linkedList.cyclical;

/**
 * 约瑟夫问题
 *
 * @author : scl
 * @date :  2022/8/18
 */
public class Joseph {
    public static void main(String[] args) {
        /*
        5个小朋友
        坐一圈
         */
        Boy lastBoy = new Boy(5);
        Boy boys = new Boy(1, new Boy(2, new Boy(3, new Boy(4, lastBoy))));
        lastBoy.next = boys;
        list(boys);
        /*
        每隔一个人抽出来一次
         */
        josephSolution(boys, 1);

    }

    private static void josephSolution(Boy boys, int i) {
        Boy current = boys;
        int interval = 0;
        while (current.next != current) {
            if (interval == i - 1) {
                System.out.println(current.next);
                current.next = current.next.next;
                interval = 0;
            }else {
                interval++;
            }
            current = current.next;

        }
        System.out.println(current);
    }


    private static void list(Boy boys) {
        int first;
        first = boys.no;
        Boy temp = boys;
        do {
            System.out.println("temp.no = " + temp.no);
            temp = temp.next;
        } while (first != temp.no);

    }
}

class Boy {
    int no;
    Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public Boy(int no, Boy next) {
        this.no = no;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}