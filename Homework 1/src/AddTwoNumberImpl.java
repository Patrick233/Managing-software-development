import java.util.*;

/**
 * This class implements AddTwoNumber interface
 */
public class AddTwoNumberImpl implements AddTwoNumber {

    public AddTwoNumberImpl (){}

    @Override
    public List<Integer> addTwoNumber(int start, int end) {
        List<Integer> result = new ArrayList<>();
        int cursor = start+1;
        while(cursor<end){
            if(cursor%2 !=0){
                result.add(cursor);
            }
            cursor++;
        }
        return result;
    }

    public void printResult(){
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter start number: ");
        int start = reader.nextInt(); // Scans the next token of the input as an int.
        System.out.println("Enter end number: ");
        int end = reader.nextInt();
        reader.close();

        List<Integer> toprint = addTwoNumber(start, end);

        for(int num: toprint){
            System.out.print(num);
            System.out.println('\t');
        }
        System.out.print('\n');
    }

}
