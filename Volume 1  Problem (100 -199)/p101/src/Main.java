import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        Integer tracker[] = new Integer[n];

        Stack<Integer> blocks[] = new Stack[n];
        Stack<Integer> revBlocks[] = new Stack[n];

        for (int i = 0; i < n; i++) {
            blocks[i] = new Stack<>();
        }

        for (int j = 0; j < n; j++) {
            blocks[j].push(j);
            tracker[j] = j;
        }

        while (!reader.hasNext("quit")) {

            String blockArrangement = reader.next();
            int x = reader.nextInt();
            String blockMethod = reader.next();
            int y = reader.nextInt();

            if (x == y) continue;
            if (tracker[x] == tracker[y]) continue;

            int clear1 = blocks[tracker[y]].indexOf(y) + 1;
            int clear2 = blocks[tracker[x]].indexOf(x) + 1;

            if (blockMethod.equals("onto")) {
                while (blocks[tracker[y]].size() != clear1) {
                    int temp;
                    temp = blocks[tracker[y]].pop();
                    blocks[temp].push(temp);
                    tracker[temp] = temp;
                }
            }

            if (blockArrangement.equals("move")){
                while (blocks[tracker[x]].size() != clear2) {
                    int moveTemp;
                    moveTemp = blocks[tracker[x]].pop();
                    blocks[moveTemp].push(moveTemp);
                    tracker[moveTemp] = moveTemp;
                }
                blocks[tracker[x]].pop();
                tracker[x] = blocks[tracker[y]].get(0);

                blocks[tracker[y]].push(x);
            }
            else if (blockArrangement.equals("pile")){
                Stack<Integer> revTemp1 = new Stack<>();

                while (blocks[tracker[x]].size() != clear2){
                    int pileTemp;
                    pileTemp = blocks[tracker[x]].pop();
                    revTemp1.push(pileTemp);
                    tracker[pileTemp] = blocks[tracker[y]].get(0);
                }
                revTemp1.push(blocks[tracker[x]].pop());
                tracker[x] = blocks[tracker[y]].get(0);

                while (!revTemp1.isEmpty())
                    blocks[tracker[y]].push(revTemp1.pop());
            }
        }

        for (int k = 0; k < n; k++) {
            revBlocks[k] = new Stack<>();
            while (!blocks[k].isEmpty())
                revBlocks[k].push(blocks[k].pop());
        }

        for (int a = 0; a < n; a++) {
            System.out.print(a + ":");
            while (!revBlocks[a].isEmpty())
                System.out.print(" " + revBlocks[a].pop());
            System.out.print("\n");
        }
    }
}