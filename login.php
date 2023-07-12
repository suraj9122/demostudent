<?php
session_start();
include '../db/db_connect.php';

// Check if the student is already logged in
if (isset($_SESSION['student_id'])) {
    // Redirect to the dashboard if already logged in
    header('Location: dashboard.php');
    exit();
}

// Process login form submission
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $email = $_POST['email'];
    $password = $_POST['hashed_password'];

    // Query the database to fetch student details based on email
    $query = "SELECT student_id, hashed_password FROM students WHERE email = '$email'";
    $result = mysqli_query($conn, $query);

    if (mysqli_num_rows($result) === 1) {
        $row = mysqli_fetch_assoc($result);
        $hashedPassword = $row['hashed_password'];

        // Verify the provided password with the hashed password
        if (password_verify($password, $hashedPassword)) {
            // Store student ID in session and redirect to the dashboard
            $_SESSION['student_id'] = $row['student_id'];
            header('Location: dashboard.php');
            exit();
        }
    }

    // If the login credentials are invalid, display an error message
    $loginError = "Invalid email or password. Please try again.";
}
?>

<!DOCTYPE html>
<html>
<head>
    <title>Student Login</title>
    <link rel="stylesheet" href="../CSS/styles.css">
    <!-- Include Bootstrap CSS link -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h2>Student Login</h2>
        <?php if (isset($loginError)) { ?>
            <div class="alert alert-danger"><?php echo $loginError; ?></div>
        <?php } ?>
        <form method="POST" action="">
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" class="form-control" id="email" name="email" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" class="form-control" id="password" name="password" required>
            </div>
            <button type="submit" class="btn btn-primary">Login</button>
        </form>
        <p>Don't have an account? <a href="registration.php">Register here</a></p>
    </div>

    <!-- Include Bootstrap JS link -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <!-- Include your custom JavaScript file if needed -->
    <script src="../JS/scripts.js"></script>
</body>
</html>
