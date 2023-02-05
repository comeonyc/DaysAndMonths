package hot;

/**
 * @author: yc_comeon
 * @date: 2023/2/5
 * @description: TODO
 **/
public class FindMediumSortedArray {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

    /**
     * 中位数的定义是 一组数据中间的数 又或者是 两个数的均值
     * <p>
     * 所以此题可以转化为寻找为寻找两个数组的第K大的数
     * 利用二分查找 每次找k/2的数，即可排除掉一部分数据。
     * 小技巧 （数组长度+1）/2  以及 （数组长度+2）/2 如果是偶数结果一致，如果是奇数 则是中位数的左右两边
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int k1 = (len1 + len2 + 1) / 2;
        int k2 = (len1 + len2 + 2) / 2;

        return (findK(nums1, 0, len1 - 1, nums2, 0, len2 - 1, k1) +
                findK(nums1, 0, len1 - 1, nums2, 0, len2 - 1, k2)) / 2;
    }

    private static double findK(int[] nums1, int left1, int right1, int[] nums2, int left2, int right2, int k) {
        int len1 = right1 - left1 + 1;
        int len2 = right2 - left2 + 1;
        if (len1 > len2) return findK(nums2, left2, right2, nums1, left1, right1, k);
        if (len1 == 0) return nums2[left2 + k - 1];
        if (k == 1) return Math.min(nums1[left1], nums2[left2]);

        int i = left1 + Math.min(len1, k / 2) - 1;
        int j = left2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return findK(nums1, left1, right1, nums2, j + 1, right2, k - (j - left2 + 1));
        } else {
            return findK(nums1, i + 1, right1, nums2, left2, right2, k - (i - left1 + 1));
        }
    }
}
