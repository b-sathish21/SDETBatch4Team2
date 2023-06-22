class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        /**
        Complexity:
            Time  - O(n X m)
            Space - O(n)
         */
        int count=0, lp=0;
        Stack <Integer> studnts = new Stack<>(); 
        Stack <Integer> sndwchs = new Stack<>(); 
        for(int i=students.length-1; i>=0; i--){
            studnts.push(students[i]);
            sndwchs.push(sandwiches[i]);
        }
        for(int k: studnts) System.out.print(k);
        System.out.println();
        for(int k: sndwchs) System.out.print(k);
        System.out.println();
        while(studnts.size() != 0){
            System.out.println("Loop ==> " + (lp++));
            System.out.println(studnts.peek() + " == " + sndwchs.peek());
            if(studnts.peek() == sndwchs.peek()){
                studnts.pop();
                sndwchs.pop();
                count=0;
                System.out.println("popped, new size is " + studnts.size());
            }
            else{
                System.out.println("Students size: " + studnts.size());
                count++;
                List<Integer> temp = new ArrayList<Integer>();
                int last = studnts.pop();
                System.out.println("Pop First: " + last);
                while(studnts.size() != 0){
                    System.out.println("Next pop: " + studnts.peek() + " Size: " + studnts.size());
                    temp.add(studnts.pop());
                }
                temp.add(last);
                for(int j=temp.size()-1 ; j>=0 ; j--){
                    System.out.println("add to stack: " + temp.get(j) + " Size: " + temp.size());
                    studnts.push(temp.get(j));
                }
                System.out.println("--> " + count + " == " + studnts.size() + "// ");
                if(count == studnts.size()) break;
                for(int k: studnts) System.out.print(k);
                System.out.println();
                for(int k: sndwchs) System.out.print(k);
                System.out.println();
            }
        }
        return count;
    }
}