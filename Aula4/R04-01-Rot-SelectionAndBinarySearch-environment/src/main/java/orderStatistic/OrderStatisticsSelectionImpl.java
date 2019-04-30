package orderStatistic;

public class OrderStatisticsSelectionImpl<T extends Comparable<T>> implements OrderStatistics<T> {

	/**
	 * Esta eh uma implementacao do calculo da estatistica de ordem seguindo a estrategia 
	 * de usar o selection sem modificar o array original. Note que seu algoritmo vai 
	 * apenas aplicar sucessivas vezes o selection ate encontrar a estatistica de ordem 
	 * desejada sem modificar o array original. 
	 * 
	 * Restricoes:
	 * - Preservar o array original, ou seja, nenhuma modificacao pode ser feita no 
	 *   array original
	 * - Nenhum array auxiliar deve ser criado e utilizado.
	 * - Voce nao pode encontrar a k-esima estatistica de ordem por contagem de
	 *   elementos maiores/menores, mas sim aplicando sucessivas selecoes (selecionar um elemento
	 *   como o selectionsort mas sem modificar nenhuma posicao do array).
	 * - Caso a estatistica de ordem nao exista no array, o algoritmo deve retornar null. 
	 * - Considerar que k varia de 1 a N 
	 * - Sugestao: o uso de recursao ajudara sua codificacao.
	 */
	@Override
	public T getOrderStatistics(T[] array, int k) {
		Integer min = 0;
		Integer max = 0;
		Integer aux = 0;
		for (int i = 0; i < array.length; i++) { // for para obter o menor e o maior valor do array.
			if(array[i].compareTo(array[min]) < 0){
				min = i;	
			}
			if(array[i].compareTo(array[max]) > 0) {
				max = i;
			}
		}
		/*
		 * for que ira pecorrer o array procurando um valor maior que o minimo e menor que o maximo
		 * assim pegando o k-esimo valor.
		 */
		for (int i = 0; i < k-1; i++) { 
			for (int j = 0; j < array.length; j++) {
				if(array[j].compareTo(array[min]) >= 0 && array[aux].compareTo(array[j]) > 0 && j != min) {
					aux = j;
				}	
			} 
			min = aux;
			aux = max;
		
		}
		return array[min];
	}
}
