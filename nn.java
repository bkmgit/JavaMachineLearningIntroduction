/*
 * A Java code to implement the XOR function using an artificial neural network
 *
 * @author Deus Jeraldy
 * @email: deusjeraldy@gmail.com
 * BSD License
 */

import java.util.Arrays;

public class NN {

	public static void main(String[] args) {

		double[][] X = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
		double[][] Y = {{0}, {1}, {1}, {0}};

		int m = 4;
		int nodes = 400;

		X = np.T(X);
		Y = np.T(Y);

		double[][] W1 = np.random(nodes, 2);
		double[][] b1 = new double[nodes][m];

		double[][] W2 = np.random(1, nodes);
		double[][] b2 = new double[1][m];

		for (int i = 0; i < 4000; i++) {
			// Forward propagaiton
			// Layer 1
			double[][] Z1 = np.add(np.dot(W1, X), b1);
			double[][] A1 = np.sigmoid(Z1);

			// Layer 2
			double[][] Z2 = np.add(np.dot(W2, A1), b2);
			double[][] A2 = np.sigmoid(Z2);

			double cost = np.cross_entropy(m, Y, A2);
			//costs.getData().add(new XYChart.Data(i, cost));
			
			// Back Propagation
			// Layer 2
			double[][] dZ2 = np.subtract(A2, Y);
			double[][] dW2 = np.divide(np.dot(dZ2, np.T(A1)), m);
			double[][] db2 = np.divide(dZ2, m);

			// Layer 1
			double[][] dZ1 = np.multiply(np.dot(np.T(W2), dZ2), np.subtract(1.0, np.power(A1, 2)));
			double[][] dW1 = np.divide(np.dot(dZ1, np.T(X)), m);
			double[][] db1 = np.divide(dZ1, m);

			// Gradient descent
			W1 = np.subtract(W1, np.multiply(0.01, dW1));
			b1 = np.subtract(b1, np.multiply(0.01, db1));

			W2 = np.subtract(W2, np.multiply(0.01, dW2));
			b2 = np.subtract(b2, np.multiply(0.01, db2));

			if (i % 400 == 0) {
				np.print("=============");
				np.print("Cost = " + cost);
				np.print("Predictions = " + Arrays.deepToString(A2));
			}
		}
	}
}
