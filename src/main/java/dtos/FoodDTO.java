package dtos;

import java.util.Arrays;

public class FoodDTO {

    meal[] meals;
    public FoodDTO(meal[] meals) {
        this.meals = meals;
    }

    public meal[] getMeals() {
        return meals;
    }

    public void setMeals(meal[] meals) {
        this.meals = meals;
    }

    @Override
    public String toString() {
        return "FoodDTO{" +
                "meals=" + Arrays.toString(meals) +
                '}';
    }

    public class meal {
        int idMeal;
        String strMeal;

        String strCategory;

        String strInstructions;

        String strMealThumb;

        String strYoutube;

        String strArea;

        public meal(int idMeal, String strMeal, String strCategory, String strInstructions, String strMealThumb, String strYoutube, String strArea) {
            this.idMeal = idMeal;
            this.strMeal = strMeal;
            this.strCategory = strCategory;
            this.strInstructions = strInstructions;
            this.strMealThumb = strMealThumb;
            this.strYoutube = strYoutube;
            this.strArea = strArea;
        }

        public String getStrMealThumb() {
            return strMealThumb;
        }

        public void setStrMealThumb(String strMealThumb) {
            this.strMealThumb = strMealThumb;
        }

        public String getStrYoutube() {
            return strYoutube;
        }

        public void setStrYoutube(String strYoutube) {
            this.strYoutube = strYoutube;
        }

        public String getStrCategory() {
            return strCategory;
        }

        public void setStrCategory(String strCategory) {
            this.strCategory = strCategory;
        }

        public String getStrInstructions() {
            return strInstructions;
        }

        public void setStrInstructions(String strInstructions) {
            this.strInstructions = strInstructions;
        }

        public int getIdMeal() {
            return idMeal;
        }

        public void setIdMeal(int idMeal) {
            this.idMeal = idMeal;
        }

        public String getStrMeal() {
            return strMeal;
        }

        public void setStrMeal(String strMeal) {
            this.strMeal = strMeal;
        }

        public String getStrArea() {
            return strArea;
        }

        public void setStrArea(String strArea) {
            this.strArea = strArea;
        }

        @Override
        public String toString() {
            return "meal{" +
                    "idMeal=" + idMeal +
                    ", strMeal='" + strMeal + '\'' +
                    ", strCategory='" + strCategory + '\'' +
                    ", strInstructions='" + strInstructions + '\'' +
                    ", strMealThumb='" + strMealThumb + '\'' +
                    ", strYoutube='" + strYoutube + '\'' +
                    ", strArea='" + strArea + '\'' +
                    '}';
        }
    }
}
