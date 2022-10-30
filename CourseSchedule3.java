class CourseSchedule3 {
    public int scheduleCourse(int[][] courses) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Arrays.sort(courses, (n1,n2) -> (n1[1]-n2[1]));
        int conow = 0;
        for (int i=0;i<courses.length;i++)
        {
            pq.add(courses[i][0]);
            conow+=courses[i][0];
            if (conow > courses[i][1]) 
            {
                conow-=pq.peek();
                pq.remove(pq.peek());
            }
        }
        return pq.size();
    }
}