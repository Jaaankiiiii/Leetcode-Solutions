class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {

        int i=0, j=0, customer=0,k=minutes, n=customers.length;
        for(j=0; j<k; j++){
            if(grumpy[j]==1) customer+=customers[j];
        }
        int maxCustomers = customer;
        i++;

        while( j<n ){
            if(grumpy[i-1]==1) customer-=customers[i-1];
            if(grumpy[j]==1) customer+=customers[j];
            maxCustomers = Math.max(maxCustomers, customer);
            i++;
            j++;
        }
        int total = maxCustomers;
        for(int m=0; m<n; m++){
            if(grumpy[m]==0) total+=customers[m];
        }
        return total;
    }
}