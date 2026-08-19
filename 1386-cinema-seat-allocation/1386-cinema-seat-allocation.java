class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int count=0;
        HashMap<Integer,boolean[]> map=new HashMap<>();
        for(int[] i:reservedSeats){
            int row=i[0]-1;
            int col=i[1]-1;
            if(!map.containsKey(row))map.put(row,new boolean[10]);
            
            map.get(row)[col]=true;
            
        }

        for(int row:map.keySet()){
            boolean[] seat=map.get(row);
            if(!seat[1]&&!seat[2]&&!seat[3]&&!seat[4]&&!seat[5]&&!seat[6]&&!seat[7]&&!seat[8])count+=2;
            else if(!seat[1]&&!seat[2]&&!seat[3]&&!seat[4])count+=1;
            else if(!seat[3]&&!seat[4]&&!seat[5]&&!seat[6])count+=1;
            else if(!seat[5]&&!seat[6]&&!seat[7]&&!seat[8])count+=1;

        }
        count+=2*(n-map.size());

    return count;    
    }
}