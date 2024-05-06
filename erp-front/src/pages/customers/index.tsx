import {
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableHeadCell,
  TableRow,
} from "flowbite-react";
import { useEffect, useState } from "react";

type Customer = {
  firstName: string;
  lastName: string;
  email: string;
};

const Customers = () => {
  const [customers, setCustomers] = useState<Customer[]>([]);

  useEffect(() => {
    const run = async () => {
      const response = await fetch(
        `${import.meta.env.VITE_API_URL}/CUSTOMER-SERVICE/customers`
      );
      const data = await response.json();
      setCustomers(data);
    };
    run();
  }, []);

  return (
    <div className="overflow-x-auto p-5">
      <h3>Customers</h3>
      <Table hoverable>
        <TableHead>
          <TableHeadCell>First name</TableHeadCell>
          <TableHeadCell>Last name</TableHeadCell>
          <TableHeadCell>Email</TableHeadCell>
        </TableHead>
        <TableBody className="divide-y">
          {customers.map((customer: Customer) => (
            <TableRow className="bg-white dark:border-gray-700 dark:bg-gray-800">
              <TableCell className="whitespace-nowrap font-medium text-gray-900 dark:text-white">
                {customer.firstName}
              </TableCell>
              <TableCell>{customer.lastName}</TableCell>
              <TableCell>{customer.email}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </div>
  );
};

export default Customers;
