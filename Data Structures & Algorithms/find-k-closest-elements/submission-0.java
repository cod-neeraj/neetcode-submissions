
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Map<Integer, List<Integer>> map = new TreeMap<>();

        for (int i = 0; i < arr.length; i++) {
            int diff = Math.abs(arr[i] - x);

            if (map.containsKey(diff)) {
                map.get(diff).add(arr[i]);
            } else {
                List<Integer> li = new ArrayList<>();
                li.add(arr[i]);
                map.put(diff, li);
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            for (int num : entry.getValue()) {
                ans.add(num);
                if (ans.size() == k) {
                    Collections.sort(ans);
                    return ans;
                }
            }
        }

        return ans;
    }
}
