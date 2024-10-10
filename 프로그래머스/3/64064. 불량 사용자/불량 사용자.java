import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public static int solution(String[] user_id, String[] banned_id) {
        for (int i = 0; i < banned_id.length; i++) {
            String s = banned_id[i];
            banned_id[i] = s.replace("*", ".");
        }

        List<List<String>> bannedMatches = new ArrayList<>();

        for (String ban : banned_id) {
            List<String> matches = new ArrayList<>();
            for (String user : user_id) {
                if(user.matches(ban)){
                    matches.add(user);
                }
            }
            bannedMatches.add(matches);
        }
        Set<Set<String>> uniqueComb = new HashSet<>();
        dfs(bannedMatches, new HashSet<>(), 0, uniqueComb);

        return uniqueComb.size();
    }

    private static void dfs(List<List<String>> bannedMatches, HashSet<String> currSet, int i, Set<Set<String>> uniqueComb) {
        if (i == bannedMatches.size()) {
            uniqueComb.add(new HashSet<>(currSet));
            return;
        }
        for(String user : bannedMatches.get(i)){
            if(!currSet.contains(user)){
                currSet.add(user);
                dfs(bannedMatches, currSet, i + 1, uniqueComb);
                currSet.remove(user);
            }
        }
    }
}