
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> arr = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        if (nums1.length <= nums2.length) {
            for (int i = 0; i < nums1.length; i++) {
                for (int j = 0; j < nums2.length; j++) {
                    if (nums1[i] == nums2[j]) {
                        nums2[j] = -1;
                        arr.add(nums1[i]);
                        break;
                    }
                }
            }
        } else {
            for (int i = 0; i < nums2.length; i++) {
                for (int j = 0; j < nums1.length; j++) {
                    if (nums2[i] == nums1[j]) {
                        nums1[j] = -1;
                        arr.add(nums2[i]);
                        break;
                    }
                }
            }
        }

        int[] result = new int[arr.size()];
        int j = 0;
        for(int i :arr){
            result[j++] = i;
        }
        return result;
    }
}