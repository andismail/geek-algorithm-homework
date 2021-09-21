package week01;

/**
 * 合并排序
 */
public class SortMerge {

    public int[] foo(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len];
        merge(nums, 0, len - 1, temp);
        return nums;
    }

    private void merge(int[] nums, int left, int right, int[] temp) {
        // 如果元素数少于7个时使用insertSort
        if (right - left <= 7) {
            insertSort(nums, left, right);
            return;
        }

        int mid = left + (right - left) / 2;

        // 递归
        merge(nums, left, mid, temp);
        merge(nums, mid + 1, right, temp);
        // 如果有序，则不用进行后续的合并
        if (nums[mid] < nums[mid + 1]) {
            return;
        }

        // 合并
        merge2(nums, left, mid, right, temp);
    }

    private void insertSort(int[] nums, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = nums[i];
            int j = i;
            while (j > 0 && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
    }

    private void merge2nums(int[] nums, int left, int right, int mid) {
        int tail = right;
        int curr;
        int p1 = mid, p2 = right;
        while (p1 > left || p2 > mid) {
            if (p1 == left) {
                curr = nums[p2--];
            } else if (p2 == mid) {
                curr = nums[p1--];
            } else if (nums[p1] > nums[p2]) {
                curr = nums[p1--];
            } else {
                curr = nums[p2--];
            }
            nums[tail--] = curr;
        }
    }

    private void merge2nums(int[] nums1, int[] nums2, int m, int n) {
        int tail = m + n - 1;
        int curr;
        int p1 = m - 1, p2 = n - 1;
        while (p1 > -1 || p2 > -1) {
            if (p1 == -1) {
                curr = nums2[p2--];
            } else if (p2 == -1) {
                curr = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                curr = nums1[p1--];
            } else {
                curr = nums2[p2--];
            }
            nums1[tail--] = curr;
        }
    }

    //private int[] merge2(int[] nums1, int[] nums2, int m, int n) {
    private int[] merge2(int[] nums, int left, int mid, int right, int[] sort) {
        int[] nums1 = new int[mid - left];
        for (int i = left; i < mid; i++) {
            nums1[i] = nums[i];
        }
        int[] nums2 = new int[right - mid];
        for (int i = mid; i <= right; i++) {
            nums2[i] = nums[i];
        }

        int m = mid - left, n = right - mid;
        int p1 = 0, p2 = 0;
        int curr;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                curr = nums2[p2++];
            } else if (p2 == n) {
                curr = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                curr = nums1[p1++];
            } else {
                curr = nums2[p2++];
            }
            sort[p1 + p2 - 1] = curr;
        }
        return sort;
    }

    public static class Foo {
        private static final int INSERTION_SORT_THRESHOLD = 2;

        public int[] sortArray(int[] nums) {
            int len = nums.length;
            int[] temp = new int[len];
            mergeSort(nums, 0, len - 1, temp);
            return nums;
        }

        private void mergeSort(int[] nums, int left, int right, int[] temp) {
            // 小区间使用插入排序
            if (right - left <= INSERTION_SORT_THRESHOLD) {
                insertionSort(nums, left, right);
                return;
            }

            int mid = left + (right - left) / 2;
            // Java 里有更优的写法，在 left 和 right 都是大整数时，即使溢出，结论依然正确
            // int mid = (left + right) >>> 1;

            mergeSort(nums, left, mid, temp);
            mergeSort(nums, mid + 1, right, temp);
            // 如果数组的这个子区间本身有序，无需合并
            if (nums[mid] <= nums[mid + 1]) {
                return;
            }

            merge2nums(nums, left, right, mid);
            //mergeOfTwoSortedArray(nums, left, mid, right, temp);
        }

        private void insertionSort(int[] arr, int left, int right) {
            for (int i = left + 1; i <= right; i++) {
                int temp = arr[i];
                int j = i;
                while (j > left && arr[j - 1] > temp) {
                    arr[j] = arr[j - 1];
                    j--;
                }
                arr[j] = temp;
            }
        }

        private void mergeOfTwoSortedArray(int[] nums, int left, int mid, int right, int[] temp) {
            System.arraycopy(nums, left, temp, left, right + 1 - left);

            int i = left;
            int j = mid + 1;

            for (int k = left; k <= right; k++) {
                if (i == mid + 1) {
                    nums[k] = temp[j];
                    j++;
                } else if (j == right + 1) {
                    nums[k] = temp[i];
                    i++;
                } else if (temp[i] <= temp[j]) {
                    // 注意写成 < 就丢失了稳定性（相同元素原来靠前的排序以后依然靠前）
                    nums[k] = temp[i];
                    i++;
                } else {
                    // temp[i] > temp[j]
                    nums[k] = temp[j];
                    j++;
                }
            }
        }

        public void merge2nums1(int[] nums, int left, int right, int mid) {
            int tail = right;
            int curr;
            int p1 = mid, p2 = right;
            while (p1 > left || p2 > mid) {
                if (p1 == left) {
                    curr = nums[p2--];
                } else if (p2 == mid) {
                    curr = nums[p1--];
                } else if (nums[p1] > nums[p2]) {
                    curr = nums[p1--];
                } else {
                    curr = nums[p2--];
                }
                nums[tail--] = curr;
            }
            System.out.println();
        }

        public void merge2nums(int[] nums, int left, int right, int mid) {
            int[] sort = new int[right - left + 1];
            int curr, i = 0;
            int p1 = left, p2 = mid + 1;
            while (i < sort.length) {
                if (p1 == mid + 1) {
                    curr = nums[p2++];
                } else if (p2 == right + 1) {
                    curr = nums[p1++];
                } else if (nums[p1] < nums[p2]) {
                    curr = nums[p1++];
                } else {
                    curr = nums[p2++];
                }
                sort[i++] = curr;
            }
            System.out.println();

            for (int j = left, k = 0; k < sort.length; k++, j++) {
                nums[j] = sort[k];
            }

            System.out.println();
        }

        public static void main(String[] args) {
            Foo f = new Foo();
            int[] nums = {8, 9, 10, 6, 7, 5, 2, 3, 1, 4};
            f.sortArray(nums);
            System.out.println();

            //f.merge2nums(nums, 0, 4, 2);
        }
    }
}
