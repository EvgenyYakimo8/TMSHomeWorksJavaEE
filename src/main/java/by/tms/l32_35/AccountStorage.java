package by.tms.l32_35;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountStorage {
    public void save(Account account) {
        try (Connection connection = PostgresConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO accounts VALUES (default,?,?,?)");
            preparedStatement.setString(1, account.getName());
            preparedStatement.setString(2, account.getUsername());
            preparedStatement.setString(3, account.getPassword());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeByID(int id) {
        try (Connection connection = PostgresConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM accounts WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<Account> getById(int id) {
        try (Connection connection = PostgresConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM accounts WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Account account = new Account();
                account.setId(resultSet.getInt(1));
                account.setName(resultSet.getString(2));
                account.setUsername(resultSet.getString(3));
                account.setPassword(resultSet.getString(4));
                return Optional.of(account);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    public List<Account> findAllAccounts() {
        List<Account> accounts = new ArrayList<>();
        try (Connection connection = PostgresConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM accounts");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Account account = new Account();
                account.setId(resultSet.getInt(1));
                account.setName(resultSet.getString(2));
                account.setUsername(resultSet.getString(3));
                account.setPassword(resultSet.getString(4));
                accounts.add(account);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return accounts;
    }

    public List<Account> findAll() {
        List<Account> accounts = new ArrayList<>();
        try (Connection connection = PostgresConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM accounts a JOIN telephones t ON t.id = a.telephone_id");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Account account = new Account();
                account.setId(resultSet.getInt(1));
                account.setName(resultSet.getString(2));
                account.setUsername(resultSet.getString(3));
                account.setPassword(resultSet.getString(4));
                account.setCodeTelephone(resultSet.getInt(7));
                account.setTelephone(resultSet.getInt(8));
                accounts.add(account);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return accounts;
    }

    /**
     * Метод с выключенным автокоммитом для записи двух запросов (связанные таблицы)
     */
    public void safeAccountAndTelephone() {
        Connection connection = null;

        try {
            connection = PostgresConnection.getConnection();
            connection.setAutoCommit(false);

            PreparedStatement preparedStatementTelephone = connection.prepareStatement("INSERT INTO telephones VALUES (default,'375','5555555',25)");
            preparedStatementTelephone.execute();
            PreparedStatement preparedStatementAccount = connection.prepareStatement("INSERT INTO accounts VALUES (default,'test2','test2','test2', 3)");
            preparedStatementAccount.execute();

            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}