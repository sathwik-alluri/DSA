class Solution {
    public List<Integer> getRow(int rowIndex) 
    {
        ArrayList<Integer> row=new ArrayList<>();
        formula(rowIndex+1, row);
        return row; 
    }
    public ArrayList<Integer> formula(int n, ArrayList<Integer> row)  
    {
        long res=1;
        row.add(1);    
        for(int i=1;i<n;i++)    
        {
            res = res * (n-i);
            res = res/i;
            row.add((int)res);
        }
        return row;
    }
}