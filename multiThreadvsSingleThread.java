public class multiThreadvsSingleThread {
    public static void main(String[] args) {
        singleThreadSolution();
    }

    public static void singleThreadSolution(){
        long startTime = System.currentTimeMillis();
        int count = 0;
        for(int i = 0; i < 1000000000; i++){
            count++;
        }
        long endTime = System.currentTimeMillis();
        System.out.print("Time For Single Threaded Solution :: " + (endTime-startTime) + " milliseconds.");
    }

    public static void doubleThreadSolution(){
        //to be done        
    }
};