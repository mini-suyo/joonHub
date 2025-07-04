import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        Arrays.sort(arr);

        double avg = (double) sum / n;
        int mean = (int) Math.round(avg);
        int median = arr[n / 2];

        int[] count = new int[8001];
        for (int i = 0; i < n; i++) {
            int index = arr[i] + 4000;
            count[index]++;
        }

        int maxFreq = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > maxFreq) {
                maxFreq = count[i];
            }
        }

        List<Integer> modeList = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] == maxFreq) {
                modeList.add(i - 4000);
            }
        }

        Collections.sort(modeList);
        int mode;
        if (modeList.size() > 1) {
            mode = modeList.get(1);
        } else {
            mode = modeList.get(0);
        }

        int range = arr[n - 1] - arr[0];

        System.out.println(mean);
        System.out.println(median);
        System.out.println(mode);
        System.out.println(range);
    }
}
