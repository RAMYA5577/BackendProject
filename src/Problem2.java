import java.util.*;

public class Problem2 {
    public static void calculateWeights(){
        Scanner sc=new Scanner(System.in);

        int ramPaid=50;
        int shamPaid=30;
        int rahimPaid=20;

        int numOfApples=sc.nextInt();

        int appleWeights[]=new int[numOfApples];
        for(int i=0;i<numOfApples;i++){
            appleWeights[i]=sc.nextInt();
        }

        //calculating total weight of all the apples bought by them
        int totalWeight=0;
        for(int i=0;i<numOfApples;i++){
            totalWeight+=appleWeights[i];
        }
        //Total amount Paid by Ram, Sham, Rahim
        int totalPaid=50+30+20;  //100

        //Calculating their shares based on the amounts paid by them
        double ramShare=((double) ramPaid/totalPaid)*totalWeight;       //==>  50/100 --> 1/2  =0.5
        double shamShare= ((double) shamPaid/totalPaid)*totalWeight;     //==>  30/100 --> 3/10 =0.3
        double rahimShare= ((double) rahimPaid/totalPaid)*totalWeight;   //==>  20/100 --> 1/5  =0.2


        //boolean array to mark taken values
        boolean isTaken[]=new boolean[numOfApples];

        //initializing lists to store distributed apples
        List<Integer> ramApples=distribute(appleWeights,isTaken,ramShare);
        List<Integer> shamApples=distribute(appleWeights,isTaken,ramShare);
        List<Integer> rahimApples=distribute(appleWeights,isTaken,ramShare);

        System.out.print("ramApples : ");
        printApples(ramApples);
        System.out.println();
        System.out.print("shamApples : ");
        printApples(shamApples);
        System.out.println();
        System.out.println("rahimApples : ");
        printApples(rahimApples);
   }

   public static List<Integer> distribute(int [] appleWeights,boolean []isTaken,double share){
        List<Integer>apples= new ArrayList<>();

        boolean flag=false;
       int index=-1;
        while(flag==false){
            int max=0;
            int min=0;
            int i=0;
            while(i<appleWeights.length){
                if(appleWeights[i]>share ){
                    continue;
                }
                else if(appleWeights[i]<=share && isTaken[i]!=true ) {
                    max = Math.max(max, appleWeights[i]);
                    min = Math.min(max,appleWeights[i]);
                    index=i;
                }
                i++;
            }
            if(share>=max){
                share-=max;
                isTaken[index]=true;
                apples.add(max);
            }
            if(share<min){
                flag=true;
            }
        }
        return apples;
   }
   public static void printApples(List<Integer> apples){
        for(int i=0;i<apples.size();i++){
            System.out.print(apples.get(i));
        }
        System.out.println();
   }
}

