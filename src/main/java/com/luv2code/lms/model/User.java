package com.luv2code.lms.model;
import jakarta.persistence.*;

    @Entity
    public class User {
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String username;
        private String role; // INSTRUCTOR or STUDENT

        public User() {
        }

        public User(Long id, String username, String role) {
            this.id = id;
            this.username = username;
            this.role = role;
        }

        // Getters & Setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

    }


