package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos: - Alocar o tamanho minimo
 * possivel para o array de contadores (C) - Ser capaz de ordenar arrays
 * contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex && leftIndex >= 0 && rightIndex <= (array.length -1) && array != null){
		 	int maior = array[0];
			int menor = array[0];
			for (int i = leftIndex; i <= rightIndex; i++) {
				if(array[i] > maior){
					maior = array[i];
				}
				if(menor > array[i]){
					menor = array[i];
				}

			}
			Integer[] arrayAux = new Integer[maior - menor +1];
			Integer[] result = new Integer[array.length];

			for(int i = 0; i < arrayAux.length; i++ ){
				arrayAux[i] = 0;
			} 

			for (int i = leftIndex; i <= rightIndex; i++) {
				arrayAux[array[i]-menor] = arrayAux[array[i]-menor] + 1;
			}

			for (int i = 1; i < arrayAux.length; i++){
				arrayAux[i] = arrayAux[i] + arrayAux[i-1];
			}  

			for (int i = rightIndex; i >= leftIndex; i--){
				arrayAux[array[i]-menor] = arrayAux[array[i]-menor]-1;
				result[arrayAux[array[i]-menor]] = array[i];
			}
			for (int i = leftIndex; i <= rightIndex ; i++) {
				array[i] = result[i];
			}

		}

	}

}
	 