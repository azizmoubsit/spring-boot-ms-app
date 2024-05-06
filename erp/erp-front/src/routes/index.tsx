import { Route, Routes } from "react-router";

import Login from "../pages/login";
import Layout from "../components/common/layout";
import Customers from "../pages/customers";
import Accounts from "../pages/accounts";

export const Router = () => {
  return (
    <Routes>
      <Route path="/auth/sign-in" element={<Login />} />
      <Route path="/" element={<Layout />}>
        <Route path="customers" element={<Customers />} />
        <Route path="accounts" element={<Accounts />} />
      </Route>

      <Route path="*" element={<div>Not found</div>} />
    </Routes>
  );
};
