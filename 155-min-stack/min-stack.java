class MinStack {

    Stack<Long> s;
    long min=0;
    public MinStack() 
    {
        s=new Stack<>();
    }
    
    public void push(int value) 
    {
       if(s.isEmpty())
        {
            min=value;
            s.push((long)value);
            return;
        } 

        if(value < min)
        {
            long newVal=(2L*value)-min;
            min=value;
            s.push(newVal);
        }
        else
        {
            s.push((long)value);
        }
    }

    /*
    When pushing a new minimum:
    encoded = 2 * newMin - oldMin

    So when popping that encoded value, we need to recover oldMin:
    encoded = 2 * newMin - oldMin
    oldMin = 2 * newMin - encoded
    */
    
    public void pop() 
    {
        if(s.isEmpty())
            return;
        
        if(s.peek() < min)    //It is modified value at top
        {
            min=(2*min) - s.peek();
            s.pop();
        }
        else
            s.pop();
        
    }
    
    public int top() 
    {
        if(s.isEmpty())
            return -1;
        
        if(s.peek() < min)
            return (int)min;
        else
            return s.peek().intValue();  
    }
    
    public int getMin() 
    {
        if(s.isEmpty())
            return -1;
    
        return (int)min;        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */