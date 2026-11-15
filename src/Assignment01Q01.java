public class Assignment01Q01 {
    public static void main(String[] args) {
        for (String string : args) {
            // Not sure if this is required
            if (string.length() == 0) {
                continue;
            }
            char firstChar = string.charAt(0);
            if (firstChar % 5 == 0) {
                System.out.println(firstChar);
            }
        }
    }
}
