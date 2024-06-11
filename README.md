# Laptop E-commerce Website

This project is a web application for a laptop e-commerce platform, built using Spring Boot.

## Features

- Product listing and search functionality
- Shopping cart and order management
- Admin panel for product management
- Payment gateway integration

## Technologies Used

- Spring Boot
- Spring Data JPA
- PostgreSQL
- 
## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java 11 or higher
- Maven
- PostgreSQL

## Installation

1. Clone the repository:

    ```sh
    git clone https://github.com/yourusername/laptop-ecommerce.git
    cd laptop-ecommerce
    ```

2. Set up the PostgreSQL database:

    - Create a new database called `laptop_ecommerce`
    - Update the `src/main/resources/application.properties` file with your MySQL database credentials

    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/laptop_ecommerce
    spring.datasource.username=your_username
    spring.datasource.password=your_password

    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    ```

3. Build the project with Maven:

    ```sh
    mvn clean install
    ```

4. Run the application:

    ```sh
    mvn spring-boot:run
    ```

5. Open your browser and navigate to `http://localhost:8080`

## Usage

### User Features

- Browse and search for laptops
- View product details
- Add laptops to the shopping cart
- Place orders

### Admin Features

- Manage products (add, edit, delete)
- View and process orders

## Contributing

To contribute to this project, follow these steps:

1. Fork this repository.
2. Create a new branch: `git checkout -b feature-branch`.
3. Make your changes and commit them: `git commit -m 'Add some feature'`.
4. Push to the original branch: `git push origin feature-branch`.
5. Create the pull request.

Alternatively, see the GitHub documentation on [creating a pull request](https://help.github.com/articles/creating-a-pull-request/).

## License

This project is licensed under the MIT License. See the `LICENSE` file for more information.

## Contact

If you want to contact me, you can reach me at `hai1342003@gmail.com`.

