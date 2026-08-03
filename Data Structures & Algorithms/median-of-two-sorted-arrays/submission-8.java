class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length < nums2.length ? (nums1.length + (nums2.length-nums1.length)/2)+1 : (nums2.length + (nums1.length-nums2.length)/2)+1;
        
        int[] arr = new int[len];
        int i = 0,j = 0,idx = 0;
        int sum = nums1.length + nums2.length;
        while(i+j<len){
            if(nums1.length==0)arr[idx++] = nums2[j++];
            else if(nums2.length==0)arr[idx++] = nums1[i++];
            else {
                if(nums1[i]< nums2[j]){
                    arr[idx++]=nums1[i];
                    i++;
                    if(i==nums1.length)break;
                }
                else{
                    arr[idx++]= nums2[j];
                    j++;
                    if(j==nums2.length)break;
                }
            }
            
        }
        if(i==nums1.length) while(j<len-i)arr[idx++]=nums2[j++];
        if(j==nums2.length) while(i<len-j)arr[idx++]=nums1[i++];
       
        // if(nums1.length == 0 || nums2.length ==0) {
        //     if(len == 2) return (double)(arr[len-1]+arr[len-2])/2;
        //     else if(len%2==0 || len ==1) return arr[len-1];
        //     else return (double)(arr[len-1]+arr[len-2])/2;
        // }
        return sum%2==1 ? arr[len-1]:(double)(arr[len-1]+arr[len-2])/2;
    }
}
