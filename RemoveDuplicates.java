public class RemoveDuplicates {
    public static void removeDuplicatesFromString(String str, int index, StringBuilder newString, boolean[] map) {
        if (index == str.length()) {
            System.out.println(newString);
            return;
        }

        char currChar = str.charAt(index);
        if (map[currChar - 'a']) {
            removeDuplicatesFromString(str, index + 1, newString, map);
        } else {
            map[currChar - 'a'] = true;
            removeDuplicatesFromString(str, index + 1, newString.append(currChar), map);
        }
    }

    public static void main(String[] args) {
        removeDuplicatesFromString("appnnacollege", 0, new StringBuilder(""), new boolean[26]);
    }
}