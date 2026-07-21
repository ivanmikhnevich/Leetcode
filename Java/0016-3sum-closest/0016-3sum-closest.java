class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) return 0; // Если меньше трех элементов, возвращаем 0
        Arrays.sort(nums); // Сортируем массив

        int closest_sum = nums[0] + nums[1] + nums[2]; // Инициализируем ближайшую сумму
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Пропускаем дубликаты

            int j = i + 1; // Указатель слева
            int k = nums.length - 1; // Указатель справа

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                // Если сумма равна цели, возвращаем ее
                if (sum == target) return sum;

                // Обновляем ближайшую сумму
                if (Math.abs(target - sum) < Math.abs(target - closest_sum)) {
                    closest_sum = sum;
                }

                // Сдвигаем указатели в зависимости от суммы
                if (sum < target) {
                    j++; // Увеличиваем сумму
                } else {
                    k--; // Уменьшаем сумму
                }
            }
        }
        return closest_sum; // Возвращаем наиболее близкую сумму
    }
}