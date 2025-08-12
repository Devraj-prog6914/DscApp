package com.example.blogapp.model

data class TeamMember(
    val name: String,
    val role: String
) {
    companion object {
        fun getSampleMembers(): List<TeamMember> {
            val roles = listOf(
                "Lead Developer", "UI/UX Designer", "Backend Developer", "Android Developer",
                "iOS Developer", "Cloud Engineer", "Project Manager", "Data Scientist",
                "Frontend Developer", "QA Engineer"
            )

            val names = listOf(
                "Aarav Sharma", "Ishita Verma", "Rohan Mehta", "Priya Nair", "Kunal Kapoor",
                "Sneha Reddy", "Aditya Joshi", "Ananya Singh", "Raj Malhotra", "Divya Patel",
                "Siddharth Rao", "Kritika Chauhan", "Harsh Gupta", "Shreya Iyer", "Nikhil Menon",
                "Meera Das", "Vikram Kaul", "Pooja Bansal", "Arjun Khanna", "Tanvi Saxena",
                "Manish Pillai", "Simran Kaur", "Rahul Sinha", "Neha Mishra", "Aniket Deshmukh",
                "Ira Kulkarni", "Saurabh Ghosh", "Aditi Raut", "Kabir Bhatia", "Ritika Agarwal",
                "Yash Vyas", "Pallavi Joshi", "Varun Anand", "Sanya Kapoor", "Ravi Krishnan",
                "Muskan Choudhary", "Deepak Chauhan", "Avni Shetty", "Karthik Reddy", "Diya Malhotra",
                "Parth Sharma", "Ishaan Gupta", "Nisha Yadav", "Vivek Mishra", "Aarohi Jain",
                "Omkar Pawar", "Lavanya Menon", "Raghav Arora", "Bhavna Singh", "Ajay Kumar"
            )

            val members = mutableListOf<TeamMember>()
            for (i in 0 until 50) {
                val name = names[i % names.size]
                val role = roles[i % roles.size]
                members.add(TeamMember(name, role))
            }
            return members
        }
    }
}
