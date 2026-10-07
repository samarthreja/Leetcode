class Solution {
    public List<String> removeInvalidParentheses(String s) {

        List<String> result = new ArrayList<>();

        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.add(s);
        visited.add(s);

        boolean found = false;

        while (!q.isEmpty()) {

            int size = q.size();

            // Process one level
            for (int j = 0; j < size; j++) {

                String curr = q.poll();

                // Check if current string is valid
                if (isValid(curr)) {
                    result.add(curr);
                    found = true;
                }

                // If valid strings are found,
                // don't generate next level
                if (found) {
                    continue;
                }

                // Remove one parenthesis
                for (int i = 0; i < curr.length(); i++) {

                    if (curr.charAt(i) != '(' &&
                        curr.charAt(i) != ')') {
                        continue;
                    }

                    String next =
                        curr.substring(0, i) +
                        curr.substring(i + 1);

                    if (!visited.contains(next)) {
                        visited.add(next);
                        q.add(next);
                    }
                }
            }

            // First valid level gives minimum removals
            if (found) {
                break;
            }
        }

        return result;
    }

    private boolean isValid(String s) {

        int balance = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                balance++;
            }

            else if (ch == ')') {
                balance--;
            }

            // More ')' than '('
            if (balance < 0) {
                return false;
            }
        }

        // All '(' must be closed
        return balance == 0;
    }
}