package queue;

import com.sun.org.apache.xml.internal.dtm.ref.DTMNodeListBase;

import java.util.Scanner;

import java.sql.SQLOutput;

/**
 * @author xql
 * @create 2021-11-07 21:26
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {

        ArraryQueue arraryQueue = new ArraryQueue(4);

        char key = ' ';
        Scanner scanner = new Scanner(System.in);

        boolean loop = true;

        while (loop){
            System.out.println("s(show)：显示队列");
            System.out.println("a(add)：添加数据到队列");
            System.out.println("g(get)：从队列中取出数据");
            System.out.println("h(head)：查看队列头的数据");
            System.out.println("e(exit)：退出程序");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    arraryQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数：");
                    int i = scanner.nextInt();
                    arraryQueue.addQueue(i);
                    break;
                case 'g': //取出数据
                    try {
                        int queue = arraryQueue.getQueue();
                        System.out.printf("输出的数字是：%d\n", queue);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int headQueue = arraryQueue.showheadQueue();
                        System.out.printf("输出的数字是：%d\n", headQueue);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }


    }

}
class ArraryQueue{
    private int maxSize;
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;

    public ArraryQueue(int maxSize){
        this.maxSize = maxSize;
        front = -1;
        rear = -1;
        arr = new int[maxSize];
    }

    public boolean isFull(){
        return front == rear;
    }

    public boolean isEmpty(){
        return rear == maxSize - 1;
    }

    public void addQueue(int num){
        if (isEmpty()){
            System.out.println("队列已满");
            return;
        }
        rear++;
        arr[rear] = num;
    }

    public int getQueue(){
        if (isFull()){
            throw new RuntimeException("队列为空");
        }
        front++;
        return arr[front];
    }

    public void showQueue(){
        if (isFull()){
            System.out.println("队列为空");
        }else {
            for (int i = 0;i < arr.length;i++){
                System.out.printf("arr[%d]=%d\n", i, arr[i]);
            }
        }
    }

    public int showheadQueue(){
        if (isFull()){
            throw new RuntimeException("队列为空");
        }else {
            return arr[front+1];
        }
    }
}
