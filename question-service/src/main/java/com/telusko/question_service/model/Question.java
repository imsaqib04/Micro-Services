package com.telusko.question_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Question {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String title;
        private String category;

        private String difficultyLevel;

        private String option1;
        private String option2;
        private String option3;
        private String option4;

        private String correctAnswer;

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public String getCategory() {
                return category;
        }

        public void setCategory(String category) {
                this.category = category;
        }

        public String getDifficultyLevel() {
                return difficultyLevel;
        }

        public void setDifficultyLevel(String difficultyLevel) {
                this.difficultyLevel = difficultyLevel;
        }

        public String getOption1() {
                return option1;
        }

        public void setOption1(String option1) {
                this.option1 = option1;
        }

        public String getOption2() {
                return option2;
        }

        public void setOption2(String option2) {
                this.option2 = option2;
        }

        public String getOption3() {
                return option3;
        }

        public void setOption3(String option3) {
                this.option3 = option3;
        }

        public String getOption4() {
                return option4;
        }

        public void setOption4(String option4) {
                this.option4 = option4;
        }

        public String getCorrectAnswer() {
                return correctAnswer;
        }

        public void setCorrectAnswer(String correctAnswer) {
                this.correctAnswer = correctAnswer;
        }
}
