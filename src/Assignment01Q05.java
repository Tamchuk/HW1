class Queue {
    private final int[] arr;
    private int front;
    private int rear;

    public Queue(int size) {
        arr = new int[size];
        front = 0;
        rear = -1;
    }

    public void enqueue(int value) {
        if (size() == arr.length) {
            throw new RuntimeException("Queue is full");
        }
        rear++;
        arr[rear % arr.length] = value;
    }

    public int size() {
        return rear - front + 1;
    }

    public int dequeue() {
        if (front > rear) {
            throw new RuntimeException("Queue is empty");
        }
        int value = arr[front % arr.length];
        front++;
        return value;
    }
}

public class Assignment01Q05 {
    public static int findShortestPath(int[][] m, int i, int j) {
        // Using BFS to find the path from i to j
        int n = m.length;
        int[] visited = new int[n];
        int[] distance = new int[n];
        Queue nodesToVisit = new Queue(n);
        nodesToVisit.enqueue(i);
        visited[i] = 1;

        while (nodesToVisit.size() > 0) {
            int currentNode = nodesToVisit.dequeue();

            if (currentNode == j) {
                return distance[currentNode];
            }

            for (int k = 0; k < n; k++) {
                if (m[currentNode][k] == 1 && visited[k] == 0) {
                    nodesToVisit.enqueue(k);
                    visited[k] = 1;
                    distance[k] = distance[currentNode] + 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(
                findShortestPath(new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } }, 0, 1)); // -1
        System.out.println(
                findShortestPath(new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } }, 1, 1)); // 0
        System.out.println(
                findShortestPath(new int[][] { { 0, 1, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 1 }, { 1, 0, 0, 0 } }, 0, 2)); // 2
        System.out.println(
                findShortestPath(new int[][] { { 0, 1, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 0 }, { 0, 0, 1, 0 } }, 0, 2)); // 2
    }
}