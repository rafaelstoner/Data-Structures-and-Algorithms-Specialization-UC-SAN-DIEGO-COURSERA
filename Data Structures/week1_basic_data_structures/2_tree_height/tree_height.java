import java.util.*;
import java.io.*;

public class tree_height {
    class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}
		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	public class TreeHeight {
		int n;
		int[] parent;
		int[] heights;


		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = in.nextInt();
			}
			heights = new int[n];
			for (int i = 0; i < n; i++) {
				heights[i] = 0;
			}
		}

		int computeHeight() {

                        // Replace this code with a faster implementation
//			int maxHeight = 0;
//			for (int vertex = 0; vertex < n; vertex++) {
//				int height = 0;
//				for (int i = vertex; i != -1; i = parent[i])
//					height++;
//				maxHeight = Math.max(maxHeight, height);
//			}
//			return maxHeight;

			int maxHeight = 0;
			for (int vertex = 0; vertex < n; vertex++) {
				int height = getHeight(vertex);
				maxHeight = Math.max(maxHeight, height);
			}
			return maxHeight;
		}
		private int getHeight(int vertex) {
			if (parent[vertex] == -1) {
				return 1; // height of the root node is 1
			}
			if (heights[vertex] != 0) {
				return heights[vertex]; // return cached height if already computed
			}
			heights[vertex] = 1 + getHeight(parent[vertex]); // compute height recursively
			return heights[vertex];
		}
	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_height().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}
	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		System.out.println(tree.computeHeight());
	}
}
