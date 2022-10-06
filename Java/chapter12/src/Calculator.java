// 실습 2
public class Calculator {
    private int memory;
    public int getMemory() {
        return memory;
    }
    public synchronized void setMemory(int memory) {    // synchronized의 위치가 핵심
        this.memory = memory;
        try{
            Thread.sleep(2000); // 2초 쉬기
        } catch(InterruptedException e){}
        System.out.println(Thread.currentThread().getName() + ":" + this.memory);
    }

}

