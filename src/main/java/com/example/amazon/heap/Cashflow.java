package com.example.amazon.heap;

import java.util.*;

public class Cashflow {
    public static void main(String[] args) {
        int[][] txn = {
                {0, 1000, 2000},
                {0, 0, 5000},
                {0, 0, 0}
        };

        System.out.println(minimizeCashFlow(txn, txn.length));
    }

    static List<Transaction> minimizeCashFlow(int[][] t, int N){
        Queue<Person> debtors = new PriorityQueue<>(16, Comparator.comparingInt(p->p.amount));
        Queue<Person> creditors = new PriorityQueue<>(16, (p1,p2)->p2.amount-p1.amount);
        Person[] persons = new Person[N];

        for(int i=0;i<N;i++)persons[i] = new Person(i);

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(t[i][j] != 0){
                    persons[i].amount -= t[i][j];
                    persons[j].amount += t[i][j];

                }
            }
        }

        for(int i=0;i<N;i++){
            if(persons[i].amount < 0 ) debtors.offer(persons[i]);
            else creditors.offer(persons[i]);
        }

        List<Transaction> txn = new ArrayList<>();
        while(!creditors.isEmpty() && !debtors.isEmpty()){
            Person debtor = debtors.poll();
            Person creditor = creditors.poll();
            int settlement = creditor.amount  + debtor.amount;
            if( settlement < 0){
                debtor.amount = settlement;
                debtors.offer(debtor);
                txn.add(new Transaction(debtor.id, creditor.id,  creditor.amount));
            } else if(settlement > 0){
                creditor.amount = settlement;
                creditors.offer(creditor);
                txn.add(new Transaction( debtor.id, creditor.id, -debtor.amount));
            } else {
                txn.add(new Transaction( debtor.id, creditor.id, -debtor.amount));
            }
        }

        return txn;
    }

    static class Person {
        int id;
        int amount;

        Person(int id){
            this.id = id;
        }
    }
    static class Transaction {
        int debtor;
        int creditor;
        int amount;
        Transaction(int debtor, int creditor, int amount){
            this.creditor = creditor;
            this.debtor = debtor;
            this.amount = amount;
        }


        @Override
        public String toString() {
            return "Transaction[" +
                    "debtor=" + debtor +
                    ",creditor=" + creditor +
                    ", amount=" + amount +
                    ']';
        }
    }
}



