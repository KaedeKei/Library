import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);//будет считываться поток ввода
        boolean exit = false;

        while(!exit) {
            System.out.println("\nМеню библиотеки: \n");
            System.out.println("1. Добавить книгу");
            System.out.println("2. Удалить книгу");
            System.out.println("3. Изменить книгу");
            System.out.println("4. Найти книгу по ISBN");
            System.out.println("5. Найти книгу по автору");
            System.out.println("6. Найти книгу по жанру");
            System.out.println("7. Показать все книги");
            System.out.println("8. Выйти");
            System.out.println("Ваш выбор: ");

            int choice = scanner.nextInt();//вводим выбранное число
            scanner.nextLine();//перевод курсора на следующую строку

            switch(choice) {
                case 1:
                    System.out.print("Введите название книги: ");
                    String title = scanner.nextLine();
                    System.out.print("Введите автора книги: ");
                    String author = scanner.nextLine();
                    System.out.print("Введите ISBN книги: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Введите жанр книги: ");
                    String genre = scanner.nextLine();
                    Book newBook = new Book(title, author, isbn, genre);
                    if(library.addBook(newBook)) {
                        System.out.println("Книга успешно добавлена");
                    }
                    else {
                        System.out.println("Книга с этим ISBN уже существует!");
                    }
                    break;
                case 2:
                    System.out.print("Введите ISBN книги для удаления: ");
                    String isbnToRemove = scanner.nextLine();
                    Book bookToRemove = library.findBookByIsbn(isbnToRemove);
                    if(bookToRemove != null && library.removeBook(bookToRemove)) {
                        System.out.println("Книга успешно удалена");
                    }
                    else {
                        System.out.println("Книга не найдена");
                    }
                    break;
                case 3:
                    System.out.print("Введите ISBN книги для изменения: ");
                    String isbnToUpdate = scanner.nextLine();
                    Book bookToUpdate = library.findBookByIsbn(isbnToUpdate);
                    if(bookToUpdate != null) {
                        System.out.print("Введите название книги: ");
                        String newTitle = scanner.nextLine();
                        System.out.print("Введите автора книги: ");
                        String newAuthor = scanner.nextLine();
                        System.out.print("Введите жанр книги: ");
                        String newGenre = scanner.nextLine();
                        bookToUpdate.setTitle(newTitle);
                        bookToUpdate.setAuthor(newAuthor);
                        bookToUpdate.setGenre(newGenre);
                        System.out.println("Книга успешно изменена");
                    }
                    else {
                        System.out.println("Книга не найдена");
                    }
                    break;
                case 4:
                    System.out.print("Введите ISBN книги для поиска: ");
                    String isbnToFind = scanner.nextLine();
                    Book foundBook = library.findBookByIsbn(isbnToFind);
                    System.out.println(foundBook != null ? foundBook : "Книга не найдена");
                    break;
                case 5:
                    System.out.print("Введите автора для поиска: ");
                    String authorToFind = scanner.nextLine();
                    library.findBooksByAuthor(authorToFind);
                    break;
                case 6:
                    System.out.print("Введите жанр для поиска: ");
                    String genreToFind = scanner.nextLine();
                    library.findBooksByGenre(genreToFind);
                    break;
                case 7:
                    System.out.println("Все книги: ");
                    library.listBooks();
                    break;
                case 8:
                    exit = true;
                    break;
                default:
                    System.out.println("Некорректное значение. Повторите ввод");
            }
        }
        scanner.close();
    }
}
