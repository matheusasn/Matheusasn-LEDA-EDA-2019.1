package sorting.divideAndConquer;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {
   private T[] arrayAuxiliar;

   @Override
   public void sort(T[] array, int leftIndex, int rightIndex) {
      if (leftIndex >= rightIndex) {
         return;
      }

      int middle = (leftIndex + rightIndex) / 2;
      sort(array, leftIndex, middle);
      sort(array, (middle + 1), rightIndex);
      merge(array, leftIndex, middle, rightIndex);

   }

   public void merge(T[] array, int leftIndex, int middle, int rightIndex) {
      this.arrayAuxiliar = Arrays.copyOf(array, array.length);

      int i = leftIndex;
      int j = (middle + 1);
      int k = leftIndex;

      while (i <= middle && j <= rightIndex) {
         if (arrayAuxiliar[i].compareTo(arrayAuxiliar[j]) <= 0) {
            array[k] = arrayAuxiliar[i];
            i++;
         } else {
            array[k] = arrayAuxiliar[j];
            j++;
         }
         k++;
      }
      while (i <= middle) {
         array[k] = arrayAuxiliar[i];
         k++;
         i++;
      }
   }
}
