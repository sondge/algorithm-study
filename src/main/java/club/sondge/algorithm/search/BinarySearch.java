package club.sondge.algorithm.search;

public class BinarySearch {

    public <E extends Comparable<E>> int searchByRecursive(E[] array, E target) {
        return searchByRecursive(array, target, 0, array.length - 1);
    }

    private <E extends Comparable<E>> int searchByRecursive(E[] array, E target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (right - left) / 2 + left;
        if (array[mid].compareTo(target) == 0) {
            return mid;
        } else if (array[mid].compareTo(target) < 0) {
            return searchByRecursive(array, target, mid + 1, right);
        }
        return searchByRecursive(array, target, left, mid - 1);
    }


    public <E extends Comparable<E>> int search(E[] array, E target) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (array[mid].compareTo(target) == 0) {
                return mid;
            } else if (array[mid].compareTo(target) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public <E extends Comparable<E>> int search3(E[] array, E target) {
        int left = 0, right = array.length;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (array[mid].compareTo(target) == 0) {
                return mid;
            } else if (array[mid].compareTo(target) < 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return -1;
    }

    public static <E extends Comparable<E>> int upper(E[] array, E target) {
        int left = 0, right = array.length;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (array[mid].compareTo(target) <= 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static <E extends Comparable<E>> int lower(E[] array, E target) {
        int left = -1, right = array.length - 1;
        while (left < right) {
//            System.out.println(left + ":" + right);
            int mid = (right - left + 1) / 2 + left;
            if (array[mid].compareTo(target) >= 0) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public static <E extends Comparable<E>> int lowerFloor(E[] array, E target) {
        int i = lower(array, target);
        if (i + 1 < array.length && array[i + 1].compareTo(target) == 0) {
            return i + 1;
        }
        return i;
    }

    public static <E extends Comparable<E>> int upperFloor(E[] array, E target) {
        int left = -1, right = array.length - 1;
        while (left < right) {
            int mid = (right - left + 1) / 2 + left;
            if (array[mid].compareTo(target) > 0) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }


    public static <E extends Comparable<E>> int ceil(E[] array, E target) {
        int index = upper(array, target);
        if (index - 1 >= 0 && index - 1 <= array.length && array[index - 1].compareTo(target) == 0) {
            return index - 1;
        }
        return index;
    }

    public static <E extends Comparable<E>> int lowerCeil(E[] array, E target) {
        int left = 0, right = array.length;
        while (left < right) {
//            System.out.println(left + ":" + right);
            int mid = (right - left) / 2 + left;
            if (array[mid].compareTo(target) >= 0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 1, 3, 3, 5, 5};
        for (int i = 0; i <= 6; i++) {
            System.out.print(lowerFloor(arr, i) + " ");
        }
        System.out.println();
//        Integer[] arr2 = {1, 1, 3, 3, 5, 5};
        for (int i = 0; i <= 6; i++) {
            System.out.print(upperFloor(arr, i) + " ");
        }
        System.out.println();
    }
}
