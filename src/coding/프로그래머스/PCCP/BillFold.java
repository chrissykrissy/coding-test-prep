package coding.프로그래머스.PCCP;

public class BillFold {
    public static int billFold(int[] wallet, int[] bill) {
        int answer = 0;
        while(Math.min(bill[0], bill[1]) > Math.min(wallet[0], wallet[1]) || Math.max(bill[0], bill[1]) > Math.max(wallet[0], wallet[1])){
            if(bill[0] > bill[1]){
                bill[0]/=2;
            }else{
                bill[1]/=2;
            }
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] wallet1 = new int[]{30, 15};
        int[] bill1 = new int[]{26, 17};
        System.out.println(billFold(wallet1, bill1));

        int[] wallet2 = new int[]{50, 50};
        int[] bill2 = new int[]{100, 241};
        System.out.println(billFold(wallet2, bill2));
    }
}
