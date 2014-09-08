import Jama.Matrix;
import java.util.Random;

public class SDAlgorithm {
	
	private static String calcSD(double[][] a, double[][] b, double[][] x, Matrix aMat) {
		Matrix matA = null;
		if (a != null) {
			matA = new Matrix(a);
		}else if (aMat != null) {
			matA = aMat;
		}
		Matrix matB = new Matrix(b);
		Matrix matX = new Matrix(x);
		double magdk = 0;
		int iterationCount = 1;
		Matrix matD = null;
		Matrix matD2 = null;
		Matrix numer = null;
		Matrix denom = null;
		Matrix fracToAdd = null;
		double accuracy = Math.pow(10, -5);
		String output = "";
		output += "Matrix x: \n" + printMatrix(matX);
		
		matD = ((matA.times(matX)).plus(matB)).times(-1.0);
		matD2 = matD.transpose().times(matD);
		magdk = Math.sqrt(matD2.get(0, 0));
		
		while (magdk >= accuracy && iterationCount < 1000000) {
			denom = matD.transpose().times(matA.times(matD));
			denom = denom.inverse();
			numer = matD.transpose().times(matD);
			fracToAdd = numer.times(denom);
			matX = (matD.times(fracToAdd)).plus(matX);
			matD = ((matA.times(matX)).plus(matB)).times(-1);
			matD2 = (matD.transpose()).times(matD);
			magdk = Math.sqrt(matD2.get(0, 0));
			iterationCount++;
		}
		if (iterationCount == 1000000) {
			output += "Loop terminated early because iteration cap reached!\n";
		}
		output += "Number of iterations: " + iterationCount + "\n\n";
		return output;
	}
	
	private static String printMatrix(Matrix m) {
		String matrix = "";
		for (int i = 0; i < m.getRowDimension(); i++) {
			for (int j = 0; j < m.getColumnDimension(); j++) {
				matrix += m.get(i, j) + "\t";
			}
			matrix += "\n";
		}
		return matrix;
	}
	
	public String example1() {
		double[][] a = new double[][]{{5, 2}, {2, 1}};
		double[][] b = new double[][]{{1}, {1}};
		double[][] x = new double[2][1];
		Random randGen = new Random();
		String output = "";
		
		output += "Matrix A: \n" + printMatrix(new Matrix(a));
		output += "Matrix b: \n" + printMatrix(new Matrix(b));
		output += "\n";
		
		for (int i = 0; i < 20; i++) {
			for (int r = 0; r < x.length; r++) {
				for (int c = 0; c < x[r].length; c++) {
					int input = randGen.nextInt(11);
					if (randGen.nextInt(11) % 2 == 0) {
						input *= -1;
					}
					x[r][c] = input;
				}
			}
			output += calcSD(a, b, x, null);
		}
		return output;
	}
	
	public String example2() {
		double[][] a = new double[][]{{1.001, -0.999}, {-0.999, 1.001}};
		double[][] b = new double[][]{{1}, {2}};
		double[][] x = new double[2][1];
		Random randGen = new Random();
		String output = "";
		
		output += "Matrix A: \n" + printMatrix(new Matrix(a));
		output += "Matrix b: \n" + printMatrix(new Matrix(b));
		output += "\n";
		
		for (int i = 0; i < 20; i++) {
			for (int r = 0; r < x.length; r++) {
				for (int c = 0; c < x[r].length; c++) {
					int input = randGen.nextInt(11);
					if (randGen.nextInt(11) % 2 == 0) {
						input *= -1;
					}
					x[r][c] = input;
				}
			}
			output += calcSD(a, b, x, null);
		}
		return output;
	}
	
	public String example3() {
		Matrix a = null;
		double[][] temp = new double[10][10];
		Matrix matTemp;
		double[][] b = new double[10][1];
		double[][] x = new double[10][1];
		Random randGen = new Random();
		String output = "";
		
		for (int count = 0; count < 5; count++) {
			
			for (int r = 0; r < temp.length; r++) {
				for (int c = 0; c < temp[r].length; c++) {
					int input = randGen.nextInt(11);
					if (randGen.nextInt() % 2 == 0) {
						input *= -1;
					}
					temp[r][c] = input;
				}
			}
			
			matTemp = new Matrix(temp);
			a = matTemp.transpose().times(matTemp);
			
			for (int r = 0; r < b.length; r++) {
				for (int c = 0; c < b[r].length; c++) {
					int input = randGen.nextInt(11);
					if (randGen.nextInt() % 2 == 0) {
						input *= -1;
					}
					b[r][c] = input;
				}
			}
			
			output += "Matrix A: \n" + printMatrix(a);
			output += "Matrix b: \n" + printMatrix(new Matrix(b));
			output += "\n";
			
			for (int i = 0; i < 5; i++) {
				for (int r = 0; r < x.length; r++) {
					for (int c = 0; c < x[c].length; c++) {
						int input = randGen.nextInt(11);
						if (randGen.nextInt(11) % 2 == 0) {
							input *= -1;
						}
						x[r][c] = input;
					}
				}
				output += calcSD(null, b, x, a);
			}
			output += "---------------------------------------------------------------------------------------------------------\n\n";
		}
		return output;
	}
}
