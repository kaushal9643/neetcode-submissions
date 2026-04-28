class Solution {
    public boolean canEatPile(int piles[], int h, int speed){
        int hours=0;
        for(int pile: piles){
            hours += (int)Math.ceil((double)pile/speed);
        }
        return h >= hours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1;
        int maxSpeed = 0;

        for(int pile: piles){
            maxSpeed = Math.max(pile, maxSpeed);
        }

        while(minSpeed < maxSpeed){
            int mid = minSpeed + (maxSpeed-minSpeed)/2;

            if(canEatPile(piles, h, mid)){
                maxSpeed = mid;
            }else{
                minSpeed = mid+1;
            }
        }
        return minSpeed;
    }
}
