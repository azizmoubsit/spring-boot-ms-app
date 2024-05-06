import {
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableHeadCell,
  TableRow,
} from "flowbite-react";
import { useEffect, useState } from "react";

type Account = {
  id: string;
  customer: {
    firstName: string;
    lastName: string;
  };
  type: string;
  balance: number;
  createdAt: string;
};

const Accounts = () => {
  const [accounts, setAccounts] = useState<Account[]>([]);

  useEffect(() => {
    const run = async () => {
      const response = await fetch(
        `${import.meta.env.VITE_API_URL}/ACCOUNT-SERVICE/accounts`
      );
      const data = await response.json();
      setAccounts(data);
    };
    run();
  }, []);

  return (
    <div className="overflow-x-auto p-5">
      <h3>Accounts</h3>
      <Table hoverable>
        <TableHead>
          <TableHeadCell>ID</TableHeadCell>
          <TableHeadCell>Customer</TableHeadCell>
          <TableHeadCell>Type</TableHeadCell>
          <TableHeadCell>Balance</TableHeadCell>
          <TableHeadCell>Date</TableHeadCell>
        </TableHead>
        <TableBody className="divide-y">
          {accounts.map((account: Account) => (
            <TableRow className="bg-white dark:border-gray-700 dark:bg-gray-800">
              <TableCell>{account.id}</TableCell>
              <TableCell className="whitespace-nowrap font-medium text-gray-900 dark:text-white">
                {account.customer.firstName} {account.customer.lastName}
              </TableCell>
              <TableCell>{account.type}</TableCell>
              <TableCell>{account.balance}</TableCell>
              <TableCell>{account.createdAt}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </div>
  );
};

export default Accounts;
